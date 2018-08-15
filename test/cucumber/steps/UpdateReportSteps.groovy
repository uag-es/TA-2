package steps



import cucumber.api.groovy.EN
import cucumber.api.groovy.Hooks
import ta.Report
import steps.ReportDataAndOperations
import pages.ReportsPages.CreateReportsPage 
import pages.ReportsPages.IndexReport

this.metaClass.mixin(Hooks)
this.metaClass.mixin(EN)


/*Feature: UpdateReport
  As a professor
  I want to update report in the system
  So I can save the new report*/

When(~/^I update report "(.*?)" with name "(.*?)" with tipo "(.*?)" with valor "(.*?)" and avaliacao "(.*?)"$/) { String name, String newName, String arg3, String arg4, String arg5 ->
	Report report = Report.findByName(name)
	report.name = newName
	report.save(flush: true)
}
