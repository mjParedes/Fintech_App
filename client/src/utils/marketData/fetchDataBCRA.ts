const URL_BCRA = process.env.NEXT_PUBLIC_URL_BCRA;

export const fetchVariableData = async (variable: string) => {
  const variablesMap: { [key: string]: number } = {
    reservasInternacionalesBCRA: 5,
    tipoCambioMinorista: 6,
    tipoCambioMayorista: 7,
    tasaPoliticaMonetaria: 8,
    badlarPesosBancosPrivados: 9,
    tasaPaseActivaBCRA: 10,
    tasaPrestamosPersonales: 11,
    baseMonetariaTotal: 12,
    inflacionMensual: 13,
    uva: 14,
  };

  const idVariable = variablesMap[variable];

  if (!idVariable) {
    console.error("Variable no válida");
    return [];
  }

  const url = `${URL_BCRA}/${idVariable}?limit=10&offset=0`;

  try {
    const response = await fetch(url, {
      headers: {
        "Content-Type": "application/json",
      },
    });

    if (!response.ok) {
      throw new Error("Error fetching data");
    }

    const data = await response.json();

    const results = data.results.slice(0, 10); 
    return results;
  } catch (error) {
    console.error("Error fetching variable data", error);
    return [];  
  }
};
