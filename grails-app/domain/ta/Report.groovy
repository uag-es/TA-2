package ta

class Report {
	String name
	List students
	static hasMany = [students: Student]
	String tipo
	double valor
	String avaliacao

	public Report(String name, String tipo, double valor, String avaliacao){
		this.name = name
		this.tipo = tipo
		this.students = []
		this.valor = valor
		this.avaliacao = avaliacao
	}

	def fillReport() {
		StudentController sc = new StudentController()
		for (int i = 0; i < Student.list().size(); i++) {
			for (Report report : Report.list()) {
				if (report.tipo.equalsIgnoreCase("Porcentagem")) {
					sc.checkConditionPercentage(Student.list().get(i).login, report)
				} else {
					sc.checkConditionAverage(Student.list().get(i), report)
				}
			}
		}
	}

	static constraints = {
		name unique : true, nullable : false, maxSize : 25
		tipo inList: ["Porcentagem", "Media"], nullable: false, maxSize : 50
		avaliacao inList: ["MA", "MPA", "MANA"], maxSize : 50
	}

	static mapping ={
		sort "name"
		sort name:"asc"
	}
	public String toString() {
		return "Nome: " + name + " | Tipo: " + tipo + " | Valor: " + valor + " |Avaliação: " + avaliacao
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Report other = (Report) obj;
		if (avaliacao == null) {
			if (other.avaliacao != null)
				return false;
		} else if (!avaliacao.equals(other.avaliacao))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (students == null) {
			if (other.students != null)
				return false;
		} else if (!students.equals(other.students))
			return false;
		if (tipo == null) {
			if (other.tipo != null)
				return false;
		} else if (!tipo.equals(other.tipo))
			return false;
		if (Double.doubleToLongBits(valor) != Double
				.doubleToLongBits(other.valor))
			return false;
		return true;
	}
}
