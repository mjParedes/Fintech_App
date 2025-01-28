import {create} from "zustand";
import { fetchVariableData } from "@/utils/marketData/fetchDataBCRA";

interface VariableData {
  value: number;  
  date: string;  
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
  loadAllVariablesData: () => void;  
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
      });

    } catch (error) {
      console.error("Error loading market variable data", error);
    }
  },
}));

export default marketStore;
