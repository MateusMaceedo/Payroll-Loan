### Payroll Loan

Migração Monolito para Microserviço. 

Requisitos não funcionais é você poder levantar qual é o TPS que a aplicação tem que ter, tempo de resposta, coisas mais voltada pra parte tecnica. 

Foi frizado muito, como conseguir colocar logo uma aplicação "no ar", já pro banco utilizar no dia a dia, para processamento, armazenamento e distribuição dos dados, "Montei rapido, poré montei de um jeito que eu entendo que é bem simples". Como eu vi no case, que vocês querem quebrar em entregas pequenas, pra poder ja ativando valor pra negocio e não ir de cara no definitivo e no mais complexo, que demandaria, mais tempo, gastos e mão de obra, então eu pensei primeiro em algo bem simples, que vai ter já uma savaguarda de segurança. Vamos ter um processo com o NAT Gateway, tendo em vista que tudo o que temos na AWS está na private subnet, é separado em camadas de acesso, "temos a region => VPC =>  private subnet", que teremos sempre um IP privado somente, e a public subnet, podemos habilitar ela pra ter um IP publico.


