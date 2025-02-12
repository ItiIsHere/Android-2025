class Main{

	public static void main (String[] args){

		Operacion op = new Operacion(1.0, 0.0, Operando.DIV);
		ICalculadora calculadora = new CalculadoraImpl();
		Double resultado = calculadora.calcular(op);
		System.out.println("Tu resutlado es " + resultado);		

	}
}
