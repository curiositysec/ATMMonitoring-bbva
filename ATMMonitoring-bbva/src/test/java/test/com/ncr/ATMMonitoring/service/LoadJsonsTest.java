package test.com.ncr.ATMMonitoring.service;

import static org.junit.Assert.fail;
import static test.com.ncr.ATMMonitoring.service.CleanTerminal.cleanDBJSON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ncr.ATMMonitoring.service.TerminalService;
import com.ncr.agent.baseData.ATMDataStorePojo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/applicationContext.xml" })
public class LoadJsonsTest {

    private static final String JSON_FOLDERS = "jsons";
    private static final String JSON_BASIC_NAME = "testData{n}.json";
    private Set<String> matriculas = new HashSet<String>();

    
   @Autowired
    private TerminalService terminalService;

    @Test
    public void testLoadJSON() {

	try {
	    List<String> jsons = getJSONContents();
	    for (String json : jsons) {
		ATMDataStorePojo dataStore = ATMDataStorePojo.fromJson(json);
		matriculas.add(dataStore.getMatricula());
		terminalService.persistDataStoreTerminal(dataStore);
	    }
	} catch (IOException e) {
	   
	    e.printStackTrace();
	    fail("can not load jsons:"+e.getMessage() );
	}

    }

    private static List<String> getJSONContents() throws IOException {
	List<String> jsons = readJSONFiles();

	return jsons;
    }

    private static List<String> readJSONFiles() throws IOException {
	int cont = 1;

	InputStream is = null;
	List<String> jsons = new ArrayList<String>();

	try {
	    do {
		String jsonFileName = JSON_BASIC_NAME.replaceAll("\\{n\\}",
			Integer.toString(cont++));
		System.out.println("name: " + jsonFileName);
		is = LoadJsonsTest.class.getClassLoader().getResourceAsStream(
			JSON_FOLDERS + "/" + jsonFileName);
		addJSONToList(is, jsons);

	    } while (is != null);

	} finally {
	    if (is != null) {
		is.close();
	    }
	}
	return jsons;
    }

    private static void addJSONToList(InputStream is, List<String> jsons)
	    throws IOException {
	if (is != null) {
	    InputStreamReader reader = new InputStreamReader(is);
	    BufferedReader bufReader = new BufferedReader(reader);
	    String lineAcum = "";
	    String line = bufReader.readLine();
	    do {

		lineAcum += line;
		line = bufReader.readLine();

	    } while (line != null);

	    jsons.add(lineAcum);
	}
    }

 
    public  void cleanup(){
	for(String matricula: this.matriculas){
	    cleanDBJSON(matricula);
	}
    }

}
