import React from 'react'

interface InvestmentCardProps {
	amount: number
	earning: number
}

export default function InvestmentCard({ amount, earning }: InvestmentCardProps) {
	return (
		<div className='flex flex-col justify-start space-y-4 p-4 shadow-lg rounded-lg'>
			<div>
				<p className='text-p1-bold'>Total de inversiones</p>
			</div>
			<div className='space-y-2'>
				<h3 className='text-h3-bold'>$ {amount.toLocaleString()}</h3>
				<p className='text-p1-regular'><span className='text-success700 text-p1-bold'> + $ {earning.toLocaleString()}</span> en 12 meses.</p>
			</div>
		</div>
	)
}
