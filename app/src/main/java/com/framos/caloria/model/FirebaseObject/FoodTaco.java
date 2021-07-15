package com.framos.caloria.model.FirebaseObject;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.firebase.firestore.IgnoreExtraProperties;
import com.google.firebase.firestore.PropertyName;

@IgnoreExtraProperties
public class FoodTaco {
    @PropertyName("Classes")
    public String classes;
    @PropertyName("Descrição")
    public String descricao;
    @PropertyName("Umidade (%)")
    public String umidade;
    @PropertyName("Energia (kcal)")
    public String energiaKcal;
    @PropertyName("Energia (kJ)")
    public String energiaKJ;
    @PropertyName("Proteína(g)")
    public String proteinaG;
    @PropertyName("Lipídeos (g)")
    public String lipideosG;
    @PropertyName("Colesterol (mg)")
    public String colesterolMg;
    @PropertyName("Carbo-idrato (g)")
    public String carboIdratoG;
    @PropertyName("Fibra Alimentar(g)")
    public String fibraAlimentarG;
    @PropertyName("Cinzas (g)")
    public String cinzasG;
    @PropertyName("Cálcio (mg)")
    public String calcioMg;
    @PropertyName("Magnésio (mg)")
    public String magnesioMg;
    @PropertyName("Número do Alimento")
    public String numerodoAlimento;
    @PropertyName("Manganês (mg)")
    public String manganesMg;
    @PropertyName("Fósforo (mg)")
    public String fosforoMg;
    @PropertyName("Ferro(mg)")
    public String ferroMg;
    @PropertyName("Sódio (mg)")
    public String sodioMg;
    @PropertyName("Potássio (mg)")
    public String potassioMg;
    @PropertyName("Cobre (mg)")
    public String cobreMg;
    @PropertyName("Zinco (mg)")
    public String zincoMg;
    @PropertyName("Retinol (mcg)")
    public String retinolMcg;
    @PropertyName("RE (mcg)")
    public String rEMcg;
    @PropertyName("RAE (mcg)")
    public String rAEMcg;
    @PropertyName("Tiamina (mg)")
    public String tiaminaMg;
    @PropertyName("Riboflavina (mg)")
    public String riboflavinaMg;
    @PropertyName("Piridoxina (mg)")
    public String piridoxinaMg;
    @PropertyName("Niacina (mg)")
    public String niacinaMg;
    @PropertyName("Vitamina-C (mg)")
    public String vitaminaCMg;
    @PropertyName("descricaoPrincipal")
    public String descricaoPrincipal;
    @PropertyName("food_id")
    public String food_id;

}
