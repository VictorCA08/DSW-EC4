package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DatabaseLoader implements CommandLineRunner {

	private final ProductoRepository repositoryI;
	private final VentaRepository repositoryM;
	private final DVentaRepository repositoryB;
	private final InfoVentaRepository repositoryN;

	@Autowired
	public DatabaseLoader(
		ProductoRepository repositoryI,
		VentaRepository repositoryM,
		DVentaRepository repositoryB,
		InfoVentaRepository repositoryN
		) {
		this.repositoryI = repositoryI;
		this.repositoryM = repositoryM;
		this.repositoryB = repositoryB;
		this.repositoryN = repositoryN;
	}

	@Override
	public void run(String... strings) throws Exception {

		this.repositoryI.save(new Producto("Creatina Monohidratada MyProtein", "70","."));
		this.repositoryI.save(new Producto("Creatina Monohidratada Kevin Levronne","75","."));
		this.repositoryI.save(new Producto("Creatina Monohidratada RC","75","."));
		Producto iCreatina = new Producto("Creatina Monohidratada Raw","80",".");
		this.repositoryI.save(iCreatina);
		Producto iProteina = new Producto("Proteina Iso Whey MyProtein","160",".");
		this.repositoryI.save(iProteina);
		this.repositoryI.save(new Producto("Proteina Iso Whey Bum","180","."));

		this.repositoryM.save(new Venta("Daniel F"));
		Venta mFreddy = new Venta("Freddy");
		this.repositoryM.save(mFreddy);
		Venta mBrian = new Venta("Brian");
		this.repositoryM.save(mBrian);

		DetalleVenta bQueen = new DetalleVenta("Queen");
		this.repositoryB.save(bQueen);

		this.repositoryN.save(new InfoVenta(bQueen, mFreddy, iCreatina));
		this.repositoryN.save(new InfoVenta(bQueen, mBrian, iProteina));


	}
}