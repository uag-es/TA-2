package steps



import cucumber.api.groovy.EN
import cucumber.api.groovy.Hooks
import ta.Report
import steps.ReportDataAndOperations
import pages.ReportsPages.CreateReportsPage 
import pages.ReportsPages.IndexReport

this.metaClass.mixin(Hooks)
this.metaClass.mixin(EN)


/*Feature: AddReport
  As a professor
  I want to register report in the system
  So I can save the report*/

Given(~/^the report "(.*?)" with tipo "(.*?)" with valor "(.*?)" and avaliacao "(.*?)" is not registered in the system$/) { String name, String tipo, double valor, String avaliacao ->
	 assert Report.findByName(name) == null 
	//throw new PendingException()
}

When(~/^I register "(.*?)" with tipo "(.*?)" with valor "(.*?)" and avaliacao "(.*?)"$/) { String name, String tipo, double valor, String avaliacao ->
	ReportDataAndOperations.createReport(name, tipo, valor, avaliacao)
		
}

Then(~/^the report "(.*?)" with tipo "(.*?)" with valor "(.*?)" and avaliacao "(.*?)" is saved in the system$/) { String name, String tipo, double valor, String avaliacao ->
	Report report = Report.findByName(name)
	assert ReportDataAndOperations.compatibleTo(report, name, tipo, valor, avaliacao)
		
}



When(~/^I add the "(.*?)" with tipo "(.*?)" with valor "(.*?)" and avaliacao "(.*?)"$/) { String name, String tipo, double valor, String avaliacao ->
	to CreateReportsPage 
	page.fillReportDetails(name, tipo, valor, avaliacao)
	page.createReport()

}

Then(~/^I see the report "(.*?)" and the tipo "(.*?)" with valor "(.*?)" and avaliacao "(.*?)" in the list of reports$/) { String name, String tipo, double valor, String avaliacao ->
	to IndexReport
	assert page.confirmReport(name, tipo, valor, avaliacao)
}
