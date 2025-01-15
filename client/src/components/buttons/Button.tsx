import React from 'react'
import clsx from 'clsx'

interface ButtonProps {
	size?: 'small' | 'medium' | 'large'
	variant?: 'solid' | 'outline' | 'text'
	type?: 'button' | 'submit' | 'reset'
	disabled?: boolean
	loading?: boolean
	icon?: React.ReactNode
	onClick?: () => void
	children: React.ReactNode
}

export default function Button({
	size = 'medium',
	variant = 'solid',
	type = 'button',
	disabled = false,
	loading = false,
	icon,
	onClick,
	children,
}: ButtonProps) {
	const baseStyles = 'inline-flex items-center justify-center rounded transition-all focus:outline-none focus:ring-2 focus:ring-offset-2'

	const sizeStyles = {
		small: 'px-3 py-1 text-sm',
		medium: 'px-4 py-2 text-base',
		large: 'px-6 py-3 text-lg',
	}

	const variantStyles = {
		solid: 'bg-blue-600 text-white hover:bg-blue-700 focus:ring-blue-500',
		outline: 'border border-blue-600 text-blue-600 hover:bg-blue-50 focus:ring-blue-500',
		text: 'text-blue-600 hover:underline focus:ring-blue-500',
	}

	const loadingStyles = loading ? 'opacity-50 pointer-events-none' : ''

	return (
		<button
			type={type}
			disabled={disabled || loading}
			onClick={onClick}
			className={clsx(
				baseStyles,
				sizeStyles[size],
				variantStyles[variant],
				loadingStyles
			)}
		>
			{loading && (
				<svg
					className="animate-spin h-4 w-4 mr-2"
					xmlns="http://www.w3.org/2000/svg"
					fill="none"
					viewBox="0 0 24 24"
				>
					<circle
						className="opacity-25"
						cx="12"
						cy="12"
						r="10"
						stroke="currentColor"
						strokeWidth="4"
					/>
					<path
						className="opacity-75"
						fill="currentColor"
						d="M4 12a8 8 0 018-8v4a4 4 0 00-4 4H4z"
					/>
				</svg>
			)}
			{icon && !loading && <span className="mr-2">{icon}</span>}
			{children}
		</button>
	)
}
