FROM python:3.11-slim

WORKDIR /app

# Copiar el archivo requirements.txt al contenedor
COPY requirements.txt .

# Instalar las dependencias
RUN pip install --no-cache-dir -r requirements.txt

# Copiar el resto del proyecto
COPY . .

# Comando para ejecutar la app
CMD ["python", "manage.py", "runserver", "0.0.0.0:8000"]

