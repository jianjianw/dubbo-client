package com.nhsoft.test;

import com.nhsoft.module.report.dto.PurchaseCycleSummary;
import com.nhsoft.module.report.rpc.ReportRpc;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


public class Test {


    public static void main(String[] args) {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                new String[]{"classpath:dubbo.xml"});
        context.start();

       // BranchLatRpc branchLatRpc = (BranchLatRpc)context.getBean("branchLatRpc");\

        ReportRpc reportRpc = (ReportRpc)context.getBean("reportRpc");
        String systemBookCode = "4020";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date dateFrom = null;
        Date dateTo = null;
        try {
            dateFrom = sdf.parse("2018-03-01");
            dateTo = sdf.parse("2018-03-31");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        List<PurchaseCycleSummary> purchaseCycleByBiz = reportRpc.findPurchaseCycleByBiz(systemBookCode,dateFrom,dateTo,null);
        System.out.println();
    }

}
