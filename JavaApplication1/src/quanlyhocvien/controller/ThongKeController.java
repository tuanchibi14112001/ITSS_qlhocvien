/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quanlyhocvien.controller;

import java.awt.CardLayout;
import java.awt.Dimension;
import java.util.List;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import quanlyhocvien.model.KhoaHoc;
import quanlyhocvien.model.KhoaHocThongKe;
import quanlyhocvien.service.KhoaHocService;
import quanlyhocvien.service.KhoaHocServiceImpl;
import quanlyhocvien.service.ThongKeService;
import quanlyhocvien.service.ThongKeServiceIplm;

/**
 *
 * @author tuan
 */
public class ThongKeController {

    private ThongKeService thongKeService = null;
    private KhoaHocService khoaHocService = null;

    public ThongKeController() {
        thongKeService = new ThongKeServiceIplm();
        khoaHocService = new KhoaHocServiceImpl();
    }

    public void setDataToChart1(JPanel jpnItem) {

        List<KhoaHocThongKe> listItem = thongKeService.getListKhoaHocThongKe();
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        if (listItem != null) {
            KhoaHoc khoahoc = new KhoaHoc();
            for (KhoaHocThongKe item : listItem) {
                khoahoc = khoaHocService.getKhoaHocID(item.getKhoaHoc().getMa_khoa_hoc());
                dataset.addValue((int) item.getTong_hocvien(), "Học viên", khoahoc.getTen_khoa_hoc());
            }
        }

        JFreeChart barChart = ChartFactory.createBarChart3D(
                "Danh Sách khóa học nhiều học viên nhất".toUpperCase(),
                "Khóa Học", "Số lượng",
                dataset, PlotOrientation.VERTICAL, true, true, false);
        
        ChartPanel chartPanel = new ChartPanel(barChart);
        chartPanel.setPreferredSize(new Dimension(jpnItem.getWidth(), 310));

        jpnItem.removeAll();
        jpnItem.setLayout(new CardLayout());
        jpnItem.add(chartPanel);
        jpnItem.validate();
        jpnItem.repaint();
    }
}
