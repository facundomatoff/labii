
public class Barco {
	
	private int columnaUno;

	private int filaUno;
	
	private int columnaDos;
	
	private int filaDos;
	
	
	public Barco(int columnaUno, int filaUno, int columnaDos, int filaDos) {
		super();
		this.columnaUno = columnaUno;
		this.filaUno = filaUno;
		this.columnaDos = columnaDos;
		this.filaDos = filaDos;
	}
	
	
	public int getColumnaUno() {
		return columnaUno;
	}

	public void setColumnaUno(int columnaUno) {
		this.columnaUno = columnaUno;
	}

	public int getFilaUno() {
		return filaUno;
	}

	public void setFilaUno(int filaUno) {
		this.filaUno = filaUno;
	}

	public int getColumnaDos() {
		return columnaDos;
	}

	public void setColumnaDos(int columnaDos) {
		this.columnaDos = columnaDos;
	}

	public int getFilaDos() {
		return filaDos;
	}

	public void setFilaDos(int filaDos) {
		this.filaDos = filaDos;
	}
}
