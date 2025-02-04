import joblib
import os
import pandas as pd
from django.http import JsonResponse
from rest_framework.decorators import api_view
from rest_framework.response import Response
from django.conf import settings

# Ruta absoluta del modelo
MODEL_PATH = os.path.join(settings.BASE_DIR, 'api', 'models', 'kmeans_model.joblib')
# Cargar el modelo KMeans
kmeans = joblib.load(MODEL_PATH)

# Datos de ejemplo (puedes conectar esto a tu base de datos)
investment_data = pd.DataFrame([
    {"investment_id": 1, "investment_type": "letras_tesoro", "risk_level": 2, "min_investment": 7655, "expected_return": 8.58},
    {"investment_id": 2, "investment_type": "plazos_fijos", "risk_level": 1, "min_investment": 9173, "expected_return": 9.51},
    {"investment_id": 3, "investment_type": "bonos_soberanos", "risk_level": 1, "min_investment": 5495, "expected_return": 6.43},
    {"investment_id": 4, "investment_type": "acciones_renta_variable", "risk_level": 2, "min_investment": 7002, "expected_return": 10.08},
    {"investment_id": 5, "investment_type": "fondos_inversion_renta_variable_internacional", "risk_level": 3, "min_investment": 7614, "expected_return": 3.36},
])

@api_view(["POST"])
def classify_user(request):
    """Clasifica a un usuario en un cluster basado en su perfil."""
    data = request.data
    user_features = [[data["age"], data["income"], data["investment_experience"], data["risk_tolerance"]]]
    cluster = kmeans.predict(user_features)[0]
    
    return Response({"user_cluster": int(cluster)})

@api_view(["POST"])
def recommend_investments(request):
    """Genera recomendaciones de inversión según el cluster del usuario."""
    data = request.data
    user_cluster = int(data["user_cluster"])
    
    # Filtrar inversiones según el nivel de riesgo promedio del cluster
    cluster_risk_level = investment_data[investment_data["risk_level"] <= user_cluster]
    
    return Response({"recommended_investments": cluster_risk_level.to_dict(orient="records")})
