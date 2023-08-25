package com.example.demo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class InfoVenta {
    
    private @Id @GeneratedValue Long id;

    @ManyToOne()
    @JoinColumn(name = "id_detalleventa")
    private DetalleVenta detalleVenta;

    @ManyToOne()
    @JoinColumn(name = "id_venta")
    private Venta venta;

    @ManyToOne()
    @JoinColumn(name = "id_producto")
    private Producto producto;

    public InfoVenta() {}

    public InfoVenta(DetalleVenta banda, Venta musico, Producto producto) {
        this.detalleVenta = detalleVenta;
        this.venta = venta;
        this.producto = producto;
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public DetalleVenta getDetalleVenta() {
		return detalleVenta;
	}

	public void setDetalleVenta(DetalleVenta detalleVenta) {
		this.detalleVenta = detalleVenta;
	}

	public Venta getVenta() {
		return venta;
	}

	public void setVenta(Venta venta) {
		this.venta = venta;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

    

}
