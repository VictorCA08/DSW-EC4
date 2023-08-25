const React = require('react');
const client = require('../client');
const {Link} = require('react-router-dom');

class HomePage extends React.Component {
	constructor(props) {
		super(props);
		this.state = { productos: [], ventas: [], detalleventas: [] };
	}
	componentDidMount() {

		client({ method: 'GET', path: '/api/productos' }).done(response => {
			this.setState({ productos: response.entity._embedded.productos });
		});

		client({ method: 'GET', path: '/api/ventas' }).done(response => {
			this.setState({ ventas: response.entity._embedded.ventas });
		});

		client({ method: 'GET', path: '/api/detalleventas' }).done(response => {
			this.setState({ detalleventas: response.entity._embedded.detalleventas });
		});

	}
	render() {
		return (
			<>
				<h1>Suplementos Deportivos</h1>

				<div style={  {"width": "100%", "display": "flex"}   }>
					<div style={{"width": "calc(100% / 3)"}}>
						<Titulo entidad="Productos" emoji="💪" />
						<InstrumentoList productos={this.state.productos} />
						<Link to="/nuevo-producto">Nuevo Producto</Link>
					</div>
					<div style={{"width": "calc(100% / 3)"}}>
						<Titulo entidad="Ventas" emoji="💸" />
						<MusicoList ventas={this.state.ventas} />
						<Link to="/nueva-venta">Nueva Venta</Link>
					</div>
					<div style={{"width": "calc(100% / 3)"}}>
						<Titulo entidad="DetalleVenta" emoji="👩🏼‍🎤" />
						<BandaList bandas={this.state.detalleventas} />
						<Link to="/nueva-detalleventa">Nuevo Detalle Venta</Link>
					</div>
				</div>


			</>
		)
	}
}

const Titulo = (props) => {
	return (
		<>
			<hr />
			<h2>{props.emoji} - {props.entidad}</h2>
			<hr />
			Lista completa de {props.entidad.toLowerCase()}
		</>
	)
}


class ProductoList extends React.Component {
	render() {
		const productos = this.props.productos.map(producto =>
			<Producto key={producto._links.self.href} producto={producto} />
		);
		return (
			<table border="1">
				<tbody>
					<tr>
						<th>Nombre</th>
						<th>Precio</th>
						<th>Acciones</th>
					</tr>
					{productos}
				</tbody>
			</table>
		)
	}
}
class VentaList extends React.Component {
	render() {
		const ventas = this.props.ventas.map(venta =>
			<Venta key={venta._links.self.href} venta={venta} />
		);
		return (
			<table border="1">
				<tbody>
					<tr>
						<th>Nombre</th>
						<th>Acciones</th>
					</tr>
					{ventas}
				</tbody>
			</table>
		)
	}
}
class DetalleVentaList extends React.Component {
	render() {
		const detalleventas = this.props.detalleventas.map(detalleventa =>
			<DetalleVenta key={detalleventa._links.self.href} detalleventa={detalleventa} />
		);
		return (
			<table border="1">
				<tbody>
					<tr>
						<th>Nombre</th>
						<th>Acciones</th>
					</tr>
					{detalleventas}
				</tbody>
			</table>
		)
	}
}

class Producto extends React.Component {
	render() {
		const id = this.props.producto._links.self.href.split("/").slice(-1)
		return (
			<tr>
				<td>{this.props.producto.nombre}</td>
				<td>{this.props.producto.precio}</td>
				<td>
					<Link to={"/ver-producto" + id}>Ver</Link> | 
					<Link to={"/editar-producto/" + id}>Editar</Link>
				</td>
			</tr>
		)
	}
}
class Venta extends React.Component {
	render() {
		const id = this.props.venta._links.self.href.split("/").slice(-1)

		return (
			<tr>
				<td>{this.props.venta.nombre}</td>
				<td>
					<Link to={"/ver-venta/" + id}>Ver</Link>
				</td>
			</tr>
		)
	}
}
class DetalleVenta extends React.Component {
	render() {
		const id = this.props.detalleventa._links.self.href.split("/").slice(-1)

		return (
			<tr>
				<td>{this.props.detalleventa.nombre}</td>
				<td>
					<Link to={"/ver-detalleventa/" + id}>Ver</Link>
				</td>
			</tr>
		)
	}
}

module.exports = HomePage;