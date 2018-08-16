Feature: UpdateReport
  As a professor
  I want to update report in the system
  So I can save the new report
    
#Cenario Controller
  Scenario: Update a report
     Given I register "relatorio de teste de report" with tipo "Porcentagem" with valor "5" and avaliacao "MANA" 
     And the report "relatorio de teste de report" with tipo "Porcentagem" with valor "5" and avaliacao "MANA" is saved in the system
     When I update report "relatorio de teste de report" with name "Novo relatório de testes" with tipo "Porcentagem" with valor "5" and avaliacao "MANA"
     Then the report "Novo relatório de testes" with tipo "Porcentagem" with valor "5" and avaliacao "MANA" is saved in the system