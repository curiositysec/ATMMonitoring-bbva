package com.ncr.ATMMonitoring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ncr.ATMMonitoring.dao.JxfsComponentDAO;
import com.ncr.ATMMonitoring.dao.XfsComponentDAO;
import com.ncr.ATMMonitoring.pojo.JxfsComponent;
import com.ncr.ATMMonitoring.pojo.XfsComponent;

/**
 * The Class XfsComponentServiceImpl.
 * 
 * Default implementation of the XfsComponentService.
 * 
 * @author Jorge López Fernández (lopez.fernandez.jorge@gmail.com)
 */

@Service("xfsComponentService")
@Transactional
public class XfsComponentServiceImpl implements XfsComponentService {

    /** The xfs component dao. */
    @Autowired
    private XfsComponentDAO xfsComponentDAO;

    /** The jxfs component dao. */
    @Autowired
    private JxfsComponentDAO jxfsComponentDAO;

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.ncr.ATMMonitoring.service.XfsComponentService#addXfsComponent(com
     * .ncr.ATMMonitoring.pojo.XfsComponent)
     */
    @Override
    public void addXfsComponent(XfsComponent xfsComponent) {
	xfsComponentDAO.addXfsComponent(xfsComponent);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.ncr.ATMMonitoring.service.XfsComponentService#listXfsComponents()
     */
    @Override
    public List<XfsComponent> listXfsComponents() {
	return xfsComponentDAO.listXfsComponents();
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.ncr.ATMMonitoring.service.XfsComponentService#getXfsComponent(java
     * .lang.Integer)
     */
    @Override
    public XfsComponent getXfsComponent(Integer id) {
	return xfsComponentDAO.getXfsComponent(id);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.ncr.ATMMonitoring.service.XfsComponentService#addJxfsComponent(com
     * .ncr.ATMMonitoring.pojo.JxfsComponent)
     */
    @Override
    public void addJxfsComponent(JxfsComponent jxfsComponent) {
	jxfsComponentDAO.addJxfsComponent(jxfsComponent);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.ncr.ATMMonitoring.service.XfsComponentService#listJxfsComponents()
     */
    @Override
    public List<JxfsComponent> listJxfsComponents() {
	return jxfsComponentDAO.listJxfsComponents();
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.ncr.ATMMonitoring.service.XfsComponentService#getJxfsComponent(java
     * .lang.Integer)
     */
    @Override
    public JxfsComponent getJxfsComponent(Integer id) {
	return jxfsComponentDAO.getJxfsComponent(id);
    }
}