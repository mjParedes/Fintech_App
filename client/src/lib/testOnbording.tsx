import { TestData } from "@/components/modal/Onbording/steps";

export default function  assignProfileFinance(test: TestData): string {
  let totalPuntos = 0;

  if (test.age === "Más de 55 años") {
    totalPuntos += 1;
  } else if (test.age === "Entre 35-55 años") {
    totalPuntos += 2;
  } else if (test.age === "Menos de 35 años") {
    totalPuntos += 3;
  }

  if (test.experience === "Ninguna experiencia") {
    totalPuntos += 1;
  } else if (test.experience === "Alguna experiencia con productos básicos") {
    totalPuntos += 2;
  } else if (test.experience === "Experiencia amplia con diversos instrumentos") {
    totalPuntos += 3;
  }

  if (test.time === "Menos de 2 años") {
    totalPuntos += 1;
  } else if (test.time === "Entre 2 y 5 años") {
    totalPuntos += 2;
  } else if (test.time === "Más de 5 años") {
    totalPuntos += 3;
  }

  if (test.lost === "Vendo todo inmediatamente") {
    totalPuntos += 1;
  } else if (test.lost === "Espero un tiempo antes de tomar una decisión") {
    totalPuntos += 2;
  } else if (test.lost === "Aprovecho para comprar más") {
    totalPuntos += 3;
  }

  if (test.objective === "Preservar mi capital") {
    totalPuntos += 1;
  } else if (test.objective === "Obtener un rendimiento moderado con riesgo limitado") {
    totalPuntos += 2;
  } else if (test.objective === "Maximizar rendimientos asumiendo mayores riesgos") {
    totalPuntos += 3;
  }

  if (totalPuntos >= 5 && totalPuntos <= 7) {
    return "Sembrador de oportunidades";
  } else if (totalPuntos >= 8 && totalPuntos <= 11) {
    return "Explorador de nuevos caminos";
  } else if (totalPuntos >= 12 && totalPuntos <= 15) {
    return "Cazador de inversiones";
  } else {
    return "Error: La suma de puntos no es válida.";
  }
}