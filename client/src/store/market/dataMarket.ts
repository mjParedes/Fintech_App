import { create } from "zustand";
import { fetchVariableData } from "@/utils/marketData/fetchDataBCRA";
import { fetchBondsData } from "@/utils/marketData/fetchDataYFBonds";
import { fetchCedearsData } from "@/utils/marketData/fetchDataYFCedears";

interface VariableData {
  value: number;
  date: string;
}

// Estructura de los datos históricos (body)
interface MarketData {
  date: string;
  open: number;
  high: number;
  low: number;
  close: number;
  volume: number;
  adjclose: number;
}

// Estructura de la información del instrumento (meta)
interface MetaData {
  symbol: string;  // El símbolo del bono o cedear
  currency: string; // Moneda
  exchangeName: string; // Nombre del intercambio
  fullExchangeName: string; // Nombre completo del intercambio
  longName: string;  // Nombre completo del instrumento
}

// Estructura completa de los datos de un bono o cedear
export interface FinancialData {
  meta: MetaData; // Información sobre el instrumento
  body: MarketData[]; // Datos históricos del instrumento
}

interface MarketState {
  reservasInternacionalesBCRA: VariableData[];
  tipoCambioMinorista: VariableData[];
  tipoCambioMayorista: VariableData[];
  tasaPoliticaMonetaria: VariableData[];
  badlarPesosBancosPrivados: VariableData[];
  tasaPaseActivaBCRA: VariableData[];
  tasaPrestamosPersonales: VariableData[];
  baseMonetariaTotal: VariableData[];
  inflacionMensual: VariableData[];
  uva: VariableData[];

  bonos: FinancialData[];
  cedears: FinancialData[];

  loadAllVariablesData: () => void;
  loadBondsData: (data: FinancialData[]) => void;
  loadCedearsData: (data: FinancialData[]) => void;
}

const marketStore = create<MarketState>((set) => ({
  reservasInternacionalesBCRA: [],
  tipoCambioMinorista: [],
  tipoCambioMayorista: [],
  tasaPoliticaMonetaria: [],
  badlarPesosBancosPrivados: [],
  tasaPaseActivaBCRA: [],
  tasaPrestamosPersonales: [],
  baseMonetariaTotal: [],
  inflacionMensual: [],
  uva: [],
  bonos: [],
  cedears: [],


  loadAllVariablesData: async () => {
    try {
      const [
        reservasInternacionalesBCRA,
        tipoCambioMinorista,
        tipoCambioMayorista,
        tasaPoliticaMonetaria,
        badlarPesosBancosPrivados,
        tasaPaseActivaBCRA,
        tasaPrestamosPersonales,
        baseMonetariaTotal,
        inflacionMensual,
        uva
      ] = await Promise.all([
        fetchVariableData("reservasInternacionalesBCRA"),
        fetchVariableData("tipoCambioMinorista"),
        fetchVariableData("tipoCambioMayorista"),
        fetchVariableData("tasaPoliticaMonetaria"),
        fetchVariableData("badlarPesosBancosPrivados"),
        fetchVariableData("tasaPaseActivaBCRA"),
        fetchVariableData("tasaPrestamosPersonales"),
        fetchVariableData("baseMonetariaTotal"),
        fetchVariableData("inflacionMensual"),
        fetchVariableData("uva")
      ]);

      const bonos = await fetchBondsData();
      const cedears = await fetchCedearsData();

      set({
        reservasInternacionalesBCRA,
        tipoCambioMinorista,
        tipoCambioMayorista,
        tasaPoliticaMonetaria,
        badlarPesosBancosPrivados,
        tasaPaseActivaBCRA,
        tasaPrestamosPersonales,
        baseMonetariaTotal,
        inflacionMensual,
        uva,
        bonos,
        cedears
      })

    } catch (error) {
      console.error("Error loading market variable data", error);
    }
  },

  loadBondsData: (data: FinancialData[]) => {
    set({ bonos: data });
  },
  loadCedearsData: (data: FinancialData[]) => {
    set({ cedears: data });
  },
}));

export default marketStore;
