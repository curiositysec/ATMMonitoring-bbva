package com.ncr.ATMMonitoring.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ncr.ATMMonitoring.dao.TerminalModelDAO;
import com.ncr.ATMMonitoring.pojo.TerminalModel;

/**
 * The Class TerminalModelServiceImpl.
 * 
 * Default implementation of the TerminalModelService.
 * 
 * @author Jorge López Fernández (lopez.fernandez.jorge@gmail.com)
 */

@Service("terminalModelService")
@Transactional
public class TerminalModelServiceImpl implements TerminalModelService {

    /** The terminal model dao. */
    @Autowired
    private TerminalModelDAO terminalModelDAO;

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.ncr.ATMMonitoring.service.TerminalModelService#addTerminalModel(com
     * .ncr.ATMMonitoring.pojo.TerminalModel)
     */
    @Override
    public void addTerminalModel(TerminalModel role) {
	terminalModelDAO.addTerminalModel(role);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.ncr.ATMMonitoring.service.TerminalModelService#getTerminalModel(java
     * .lang.Integer)
     */
    @Override
    public TerminalModel getTerminalModel(Integer id) {
	return terminalModelDAO.getTerminalModel(id);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.ncr.ATMMonitoring.service.TerminalModelService#getTerminalModelByModel
     * (java.lang.String)
     */
    @Override
    public TerminalModel getTerminalModelByModel(String model) {
	return terminalModelDAO.getTerminalModelByModel(model);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.ncr.ATMMonitoring.service.TerminalModelService#
     * getTerminalModelByProductClass(java.lang.String)
     */
    @Override
    public TerminalModel getTerminalModelByProductClass(String productClass) {
	return terminalModelDAO.getTerminalModelByProductClass(productClass);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.ncr.ATMMonitoring.service.TerminalModelService#listTerminalModels()
     */
    @Override
    public List<TerminalModel> listTerminalModels() {
	return terminalModelDAO.listTerminalModels();
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.ncr.ATMMonitoring.service.TerminalModelService#
     * listTerminalModelsByManufacturer()
     */
    @Override
    public Map<String, List<TerminalModel>> listTerminalModelsByManufacturer() {
	Map<String, List<TerminalModel>> data = new HashMap<String, List<TerminalModel>>();
	List<TerminalModel> terminalModels = terminalModelDAO
		.listTerminalModels();
	String manufacturer;
	for (TerminalModel terminalModel : terminalModels) {
	    manufacturer = terminalModel.getManufacturer();
	    if (manufacturer != null) {
		if (!data.containsKey(manufacturer)) {
		    data.put(manufacturer, new ArrayList<TerminalModel>());
		}
		data.get(manufacturer).add(terminalModel);
	    }
	}
	data.put("allManufacturers", terminalModels);
	return data;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.ncr.ATMMonitoring.service.TerminalModelService#updateTerminalModel
     * (com.ncr.ATMMonitoring.pojo.TerminalModel)
     */
    @Override
    public void updateTerminalModel(TerminalModel terminalModel) {
	terminalModelDAO.updateTerminalModel(terminalModel);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.ncr.ATMMonitoring.service.TerminalModelService#removeTerminalModel
     * (java.lang.Integer)
     */
    @Override
    public void removeTerminalModel(Integer id) {
	terminalModelDAO.removeTerminalModel(id);
    }
}