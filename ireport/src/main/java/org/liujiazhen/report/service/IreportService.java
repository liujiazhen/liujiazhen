package org.liujiazhen.report.service;

import net.sf.jasperreports.engine.JRException;

public interface IreportService {
    byte[] front()  throws JRException;
    byte[] back() throws JRException;
}
