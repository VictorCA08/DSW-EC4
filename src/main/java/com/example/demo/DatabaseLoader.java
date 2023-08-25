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

		this.repositoryM.save(new Venta("30"));
		Venta Venta1 = new Venta("22");
		this.repositoryM.save(Venta1);
		Venta Venta2 = new Venta("45");
		this.repositoryM.save(Venta2);

		DetalleVenta detalleVenta = new DetalleVenta("DetalleVenta1");
		this.repositoryB.save(detalleVenta);

		this.repositoryN.save(new InfoVenta(detalleVenta, Venta1, iCreatina));
		this.repositoryN.save(new InfoVenta(detalleVenta, Venta2, iProteina));


	}
}