from django.urls import path
from .views import classify_user, recommend_investments

urlpatterns = [
    path('classify/', classify_user, name='classify-user'),
    path('recommendations/', recommend_investments, name='recommend-investments'),
]
