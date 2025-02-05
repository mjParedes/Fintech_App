import Button from '@/components/ui/Button'
import { ExpandMore } from '@mui/icons-material'
import React, { useState, useEffect } from 'react'
import marketStore from '@/store/market/dataMarket'
import LineChart from '@/components/graphs/linealChart'

export interface Asset {
  name: string
  price: number
  change: string
  trend: string
  historicalData: { 
    date: string
    open: number
    high: number
    low: number
    close: number
    volume: number
    adjclose: number
  }[]
}

interface AssetListProps {
  assets: Asset[] 
}

export default function AssetList({ assets }: AssetListProps) {
  const [isExpanded, setIsExpanded] = useState(false)
  const [visibleAssets, setVisibleAssets] = useState(4)
  const loadAllVariablesData = marketStore((state) => state.loadAllVariablesData)
  const [assetsWithMarketInfo, setAssetsWithMarketInfo] = useState<Asset[]>([]) // Aquí almacenamos los activos con datos históricos

  const handleExpandToggle = () => {
    setIsExpanded(!isExpanded)
    setVisibleAssets(4)
  }

  const handleLoadMoreToggle = () => {
    setVisibleAssets(visibleAssets === 4 ? assets.length : 4)
  }

  // Obtener los datos del mercado por el nombre del activo
  const getMarketData = (assetName: string) => {
    const marketData = marketStore.getState() 
    const allAssets = [...marketData.bonos, ...marketData.cedears] 
    return allAssets.find(item => item.meta.longName.toLowerCase() === assetName.toLowerCase())
  }

  useEffect(() => {
    loadAllVariablesData()

    const updatedAssets = assets.map((asset) => {
      const marketData = getMarketData(asset.name)

      // Si el mercado proporciona información histórica
      const historicalData = marketData ? marketData.body : []
	  console.log( marketData)

      return {
        ...asset,
        price: marketData ? marketData.body[0].close : asset.price,
        change: marketData ? (marketData.body[0].close - marketData.body[0].open).toFixed(2) : asset.change,
        trend: marketData && (marketData.body[0].close - marketData.body[0].open) > 0 ? 'positive' : 'negative',
        historicalData: historicalData, 
      }
    })
    setAssetsWithMarketInfo(updatedAssets)
  }, [assets, loadAllVariablesData])



  return (
    <div className='bg-white rounded-lg shadow-sm p-6'>
      <h5 className='text-h5-semibold mb-4'>Activos</h5>
      <p className='text-gray-600 mb-6'>
        En esta sección, encontrarás detalles sobre los activos en los que hemos invertido, incluyendo tendencias y análisis de mercado.
      </p>
      <div className='flex justify-between items-center'>
        <h6 className='text-h6-semibold text-white800'>Acciones</h6>
        <div className='flex justify-center mb-4'>
          <button onClick={handleExpandToggle} className='text-white900 transition-colors'>
            <ExpandMore className={`transform transition-transform ${isExpanded ? 'rotate-180' : 'rotate-0'}`} />
          </button>
        </div>
      </div>

      {isExpanded && (
        <div className='flex flex-wrap justify-between items-center gap-2'>
          {assetsWithMarketInfo.slice(0, visibleAssets).map((asset, index) => (
            <div
              key={index}
              className='flex flex-col justify-between items-center p-4 border rounded-lg hover:shadow-md transition-shadow bg-primary50 w-[200px] h-[160px]'
            >
              <div className='flex flex-col items-center space-y-2'>
                <h6 className='text-h6-bold'>{asset.name}</h6>
                <p className='text-p1-regular text-white700'>{asset.price}</p>
              </div>
			  <LineChart historicalData={asset.historicalData} />
              <p className={`font-semibold ${asset.trend === 'positive' ? 'text-green-600' : 'text-red-600'}`}>{asset.change}</p>
              {/* Aquí puedes agregar el gráfico */}
            </div>
          ))}
        </div>
      )}

      {isExpanded && assetsWithMarketInfo.length > 4 && (
        <Button
          variant='text'
          onClick={handleLoadMoreToggle}
          className='mt-6 py-2 text-p1-semibold text-primary900 focus:transparent border-none focus:outline-none focus:ring-0 active:bg-transparent active:border-none'
        >
          {visibleAssets === 4 ? 'Ver más' : 'Ver menos'}
        </Button>
      )}
    </div>
  )
}
