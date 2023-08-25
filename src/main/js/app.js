const React = require('react');
const ReactDOM = require('react-dom');
const {createBrowserRouter, RouterProvider} = require('react-router-dom');

const HomePage = require('./pages/home');
const NuevoVentaPage = require('./pages/nueva-venta');
const VerIProductoPage = require('./pages/ver-producto');
const NuevoProductoPage = require('./pages/nuevo-producto');
const VerVentaPage = require('./pages/ver-venta');
const EditarProductoPage = require('./pages/editar-producto');
const VerDetalleVentaPage = require('./pages/ver-detalleventa');
const NuevoInfoVentaPage = require('./pages/nueva-infoventa');


const router = createBrowserRouter([
	{ path: '/', element: <HomePage /> },
	{ path: '/ver-producto/:id', element: <VerProductoPage /> },
	{ path: '/nuevo-producto', element: <NuevoProductoPage /> },
	{ path: '/ver-venta/:id', element: <VerVentaPage /> },
	{ path: '/nueva-venta', element: <NuevaVentaPage /> },
	{ path: '/editar-producto/:id', element: <EditarProductoPage /> },
	{ path: '/ver-detalleventa/:id', element: <VerDetalleVentaPage /> },
	{ path: '/ver-detalleventa/:id/nueva-infoventa', element: <NuevoInfoVentaPage /> },


])


ReactDOM.render(
	<React.StrictMode>
		<RouterProvider router={router} />
	</React.StrictMode>,
	document.getElementById('react'))
