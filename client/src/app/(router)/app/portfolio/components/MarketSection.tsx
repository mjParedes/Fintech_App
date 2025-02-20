import { CardInvestment } from '@/components/cards/InvestmentCard';
import LineChartLittle from '@/components/graphs/linealChartLittle';
import Button from '@/components/ui/Button';
import KeyboardArrowDownIcon from '@mui/icons-material/KeyboardArrowDown';
import React, { useState, useMemo } from 'react';

export interface MarketAsset {
  meta: {
    symbol: string;
    currency: string;
    exchangeName: string;
    fullExchangeName: string;
    longName: string;
  };
  body: Array<MarketData>;
}

export interface MarketData {
  date: string;
  open: number;
  high: number;
  low: number;
  close: number;
  volume: number;
  adjclose: number;
  trend?: string;
}

interface MarketSectionProps {
  bonos: MarketAsset[];
  cedears: MarketAsset[];
}

export default function MarketSection({ bonos, cedears }: MarketSectionProps) {
  const [tabSelected, setTabSelected] = useState<'En alza' | 'A la baja' | 'Bonos' | 'Cedears'>('En alza');
  const [open, setOpen] = useState(false);
  const getTrend = (data: Array<MarketData>) => {
    return data.map((item) => {
      const variationPercentage = ((item.close - item.open) / item.open) * 100;
      const trend = variationPercentage > 0 ? 'up' : variationPercentage < 0 ? 'down' : 'neutral';
      return { ...item, trend };
    });
  };

  const assetsWithTrend = useMemo(() => {
    return [...bonos, ...cedears].map((asset) => ({
      ...asset,
      body: getTrend(asset.body),
    }));
  }, [bonos, cedears]);

  const latestData = useMemo(() => {
    return assetsWithTrend.map((asset) => {
      const latestMarketData = asset.body[asset.body.length - 1]; // Último dato del array con la tendencia
      return {
        symbol: asset.meta.symbol,
        close: latestMarketData.close,
        trend: latestMarketData.trend,
        longName: asset.meta.longName,
        open: latestMarketData.open,
      };
    });
  }, [assetsWithTrend]);


  const filteredData = useMemo(() => {
    if (tabSelected === 'Bonos') {
      return latestData.filter((item) => bonos.some((b) => b.meta.symbol === item.symbol));
    } else if (tabSelected === 'Cedears') {
      return latestData.filter((item) => cedears.some((c) => c.meta.symbol === item.symbol));
    } else if (tabSelected === 'En alza') {
      return latestData.filter((item) => item.trend === 'up');
    } else if (tabSelected === 'A la baja') {
      return latestData.filter((item) => item.trend === 'down');
    }
    return latestData;
  }, [tabSelected, latestData,bonos,cedears]);

  const [selectedAsset, setSelectedAsset] = useState<MarketAsset | null>(null);


  const handleOpen = (symbol: string) => {

    const asset = [...bonos, ...cedears].find((a) => a.meta.symbol === symbol);
    if (asset) {
      setSelectedAsset(asset);
      setOpen(true);
    }
  };

  const handleClose = () => {
    setOpen(false);
    setSelectedAsset(null);
  };

  return (
    <div className="flex flex-col gap-6 w-full">
      <header className="flex flex-col gap-4">
        <h5 className="text-h5-semibold py-2">Mercado</h5>
        <p className="text-p1-regular text-white700">
          Últimas tendencias y análisis del mercado para que tomes decisiones informadas.
        </p>
      </header>

      <nav className="flex flex-wrap gap-2 justify-center">
        {['En alza', 'A la baja', 'Bonos', 'Cedears'].map((tab) => (
          <Button
            key={tab}
            size="small"
            variant={tabSelected === tab ? 'text' : 'basic'}
            className="rounded-lg bg-white100"
            onClick={() => setTabSelected(tab as 'En alza' | 'A la baja' | 'Bonos' | 'Cedears')}
          >
            {tab}
          </Button>
        ))}
      </nav>

      <section className="p-4 bg-white rounded-lg shadow-md w-full">
  <h6 className="text-h6-semibold mb-3">{tabSelected}</h6>
  {tabSelected !== 'Bonos' && tabSelected !== 'Cedears' ? (
    <div className="flex flex-col gap-6 w-full">
      {/* Acciones */}
      <div>
        <h1 className="text-h6-semibold mb-2">Acciones</h1>
        <div className="flex flex-col gap-3 w-full">
          {filteredData
            .filter((item) => cedears.some((ced) => ced.meta.symbol === item.symbol))
            .map((item) => (
              <div key={item.symbol}>
              <div className="flex justify-between items-center border-b pb-2 w-full" onClick={() => handleOpen(item.symbol)}>
                <div className="w-[20vh]">
                  <p className="text-p1-semibold">{item.symbol}</p>
                  <p className="text-p1-regular text-white400 w-[20vh] overflow-hidden whitespace-nowrap text-ellipsis">
                    {item.longName}
                  </p>
                </div>
                <div className="text-right flex flex-row gap-3 justify-center items-center">
                  <LineChartLittle bonos={bonos} cedears={cedears} symbol={item.symbol} />
                   <div><p className="text-p1-regular">${item.close.toFixed(2)}</p>
                  <p
                    className={`font-semibold ${
                      item.trend === 'up' ? 'text-green-600' : item.trend === 'down' ? 'text-red-600' : ''
                    }`}
                  >
                    {item.trend === 'up'
                      ? `+${(((item.close - item.open) / item.open) * 100).toFixed(2)}%`
                      : item.trend === 'down'
                      ? `${(((item.open - item.close) / item.open) * 100).toFixed(2)}%`
                      : '0%'}
                  </p>
                  </div>
                  <div className="flex justify-center items-center">
                  <KeyboardArrowDownIcon/>
                  </div>
                </div>
                </div>
                {open && selectedAsset?.meta.symbol === item.symbol ? <CardInvestment onClose={handleClose} asset={selectedAsset} /> : ""}
              </div>
            ))}
        </div>
      </div>

      {/* Bonos */}
      <div>
        <h1 className="text-h6-semibold mb-2">Bonos</h1>
        <div className="flex flex-col gap-3 ">
          {filteredData
            .filter((item) => bonos.some((bono) => bono.meta.symbol === item.symbol))
            .map((item) => (
              <div key={item.symbol}>
              <div className="flex justify-between items-center border-b pb-2" onClick={() => handleOpen(item.symbol)}>
              <div className="w-[20vh]">
                  <p className="text-p1-semibold">{item.symbol}</p>
                  <p className="text-p1-regular text-white400 w-[20vh] overflow-hidden whitespace-nowrap text-ellipsis">
                    {item.longName}
                  </p>
                </div>
                <div className="text-right flex flex-row gap-3 justify-center items-center">
                  <LineChartLittle bonos={bonos} cedears={cedears} symbol={item.symbol} />
                   <div><p className="text-p1-regular">${item.close.toFixed(2)}</p>
                  <p
                    className={`font-semibold ${
                      item.trend === 'up' ? 'text-green-600' : item.trend === 'down' ? 'text-red-600' : ''
                    }`}
                  >
                    {item.trend === 'up'
                      ? `+${(((item.close - item.open) / item.open) * 100).toFixed(2)}%`
                      : item.trend === 'down'
                      ? `${(((item.open - item.close) / item.open) * 100).toFixed(2)}%`
                      : '0%'}
                  </p>
                  </div>
                  <div className="flex justify-center items-center">
                  <KeyboardArrowDownIcon/>
                  </div>
                </div>
                </div>
                {open && selectedAsset?.meta.symbol === item.symbol ? <CardInvestment onClose={handleClose} asset={selectedAsset} /> : ""}
              </div>
            ))}
        </div>
      </div>
    </div>
  ) : (
    <div className="flex flex-col gap-3" >
      {filteredData.map((item) => (
        <div key={item.symbol}>
        <div className="flex justify-between items-center border-b pb-2" onClick={() => handleOpen(item.symbol)}>
        <div className="w-[20vh]">
            <p className="text-p1-semibold">{item.symbol}</p>
            <p className="text-p1-regular text-white400 w-[20vh] overflow-hidden whitespace-nowrap text-ellipsis">
              {item.longName}
            </p>
          </div>
          <div className="text-right flex flex-row gap-3 justify-center items-center">
            <LineChartLittle bonos={bonos} cedears={cedears} symbol={item.symbol} />
             <div><p className="text-p1-regular">${item.close.toFixed(2)}</p>
            <p
              className={`font-semibold ${
                item.trend === 'up' ? 'text-green-600' : item.trend === 'down' ? 'text-red-600' : ''
              }`}
            >
              {item.trend === 'up'
                ? `+${(((item.close - item.open) / item.open) * 100).toFixed(2)}%`
                : item.trend === 'down'
                ? `${(((item.open - item.close) / item.open) * 100).toFixed(2)}%`
                : '0%'}
            </p>
            </div>
            <div className="flex justify-center items-center">
            <KeyboardArrowDownIcon/>
            </div>
          </div>
          </div>
          {open && selectedAsset?.meta.symbol === item.symbol ? <CardInvestment onClose={handleClose} asset={selectedAsset} /> : ""}
        </div>
      ))}
    </div>
  )}
</section>

    </div>
  );
}
