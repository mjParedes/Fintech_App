import { FinancialData } from '@/store/market/dataMarket';

const API_KEY_YF = process.env.NEXT_PUBLIC_API_KEY_YF;
const API_HOST_YF = process.env.NEXT_PUBLIC_API_HOST_YF;
const URL_YF = process.env.NEXT_PUBLIC_URL_YF;

  export const fetchBondsData = async (): Promise<FinancialData[]> => {
    const bonos = [
      'AL30.BA', 'AL35.BA', 'GD30.BA', 'GD35.BA', 'TX24.BA',
      'TX26.BA', 'PR13.BA', 'TV24.BA', 'AE38.BA', 'DICP.BA'
    ];
  
    const fetchPromises = bonos.map(async (symbol) => {
      const response = await fetch(`${URL_YF}/quote/${symbol}`, {
        method: 'GET',
        headers: {
          'X-RapidAPI-Key': `${API_KEY_YF}`,
          'X-RapidAPI-Host': `${API_HOST_YF}`
        }
      });
  
      const data = await response.json();
  
      return {
        meta: {
          symbol: data.meta.symbol,
          currency: data.meta.currency,
          exchangeName: data.meta.exchangeName,
          fullExchangeName: data.meta.fullExchangeName,
          longName: data.meta.longName
        },
        body: data.body.slice(-7)
      };
    });
  
    return Promise.all(fetchPromises);
  };
  