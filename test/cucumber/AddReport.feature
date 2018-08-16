Feature: AddReport
  As a professor
  I want to register report in the system
  So I can save the report

#Cenario Controler 
Scenario: Add a new Report
	Given the report "relatorio de teste de report" with tipo "Porcentagem" with valor "5" and avaliacao "MANA" is not registered in the system
    When I register "relatorio de teste de report" with tipo "Porcentagem" with valor "5" and avaliacao "MANA" 
	Then the report "relatorio de teste de report" with tipo "Porcentagem" with valor "5" and avaliacao "MANA" is saved in the system

#Cenario GUI
  Scenario: Message from the new report registration
     Given I am in the "register report" page
     When I add the "relatorio de teste de report" with tipo "Porcentagem" with valor "5" and avaliacao "MANA"
     Then I see the report "relatorio de teste de report" and the tipo "Porcentagem" with valor "5" and avaliacao "MANA" in the list of reports
     