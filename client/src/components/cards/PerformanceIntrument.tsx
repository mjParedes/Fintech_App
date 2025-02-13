import { BarChartBig } from "../graphs/BarChartBig";
import { InstrumentProps } from "./GeneralInformation"

export const PerformanceInstrument = ({ id, market }: InstrumentProps) =>{
    const instrument = market.flat().find(item => item.meta.symbol === id)
    const historicalData = instrument?.body || []

    if (!instrument) {
        return <p>No se encontró el instrumento</p>;
      }

    const variation = (instrument.body[instrument.body.length - 1].close - instrument.body[0].close)/instrument.body[0].close*100
    return (
    <div className="p-4 w-full m-auto">
        <h1 className="text-h6-semibold">Desempeño</h1>
        <p className="text-p2-regular text-white400 text-center">En los ultimos 10 días</p>
        <div className="flex justify-center items-center">
        <BarChartBig historicalData={historicalData} />
        </div>

        <p>Al </p>

        <div className="text-white800">
            <label className="flex flex-row">
                <h2 className="text-p1-regular">Precio</h2>
                <h2 className="text-p1-semibold">{instrument.body[instrument.body.length - 1].close}</h2>
            </label>
            <label className="flex flex-row">
                <h2 className="text-p1-regular">Variación</h2>
                <h2 className="text-p1-semibold">{variation > 0 
                            ? <span className="text-green">↑</span>
                            : <span className="text-warning">↓</span>} {variation} %</h2>
            </label>
            <label className="flex flex-row">
                <h2 className="text-p1-regular">Máx y Mín recientes</h2>
                <h2 className="text-p1-semibold"></h2>
            </label>
            <label className="flex flex-row">
                <h2 className="text-p1-regular">Volumen de operación</h2>
                <h2 className="text-p1-semibold">{instrument.body[instrument.body.length - 1].volume} diario</h2>
            </label>
            <label className="flex flex-row">
                <h2 className="text-p1-regular">Apertura</h2>
                <h2 className="text-p1-semibold"> $ {instrument.body[instrument.body.length - 1].open}</h2>
            </label>
            <label className="flex flex-row">
                <h2 className="text-p1-regular">Cierre</h2>
                <h2 className="text-p1-semibold">$ {instrument.body[instrument.body.length - 1].open}</h2>
            </label>
            <label className="flex flex-row">
                <h2 className="text-p1-regular">Retorno histórico</h2>
                <h2 className="text-p1-semibold">{instrument.body[instrument.body.length - 1].adjclose}</h2>
            </label>
        </div>

    </div>)
}