package hello;
import javax.validation.constraints.NotNull;

public class ModelForm {

    private int myopia;
    private int anxiety; //тревожность
    private int vegStatus;
    @NotNull
    private String age;
    @NotNull
    private String time;
    @NotNull
    private String IN;
    @NotNull
    private String vision;
    @NotNull
    private String correction;
    @NotNull
    private String refractionWithC;
    @NotNull
    private String refractionWithoutC;
    @NotNull
    private String OOA;
    @NotNull
    private String OOAplus;
    @NotNull
    private String OOAminus;
    private boolean method;//false=A, true=B
    private boolean heredity;//наследственность
    private int model;
    private String result;

    public String count(){
        if(model==1) result=this.count1();
        if(model==2) result=this.count2();
        if(model==3) result=this.count3();
        return result;
    }

    public String count1(){
        if(toInt(age)<4) return "Оптимального метода нет";
        if(method){
            if(myopia<3) return "Оптимален метод B";
            return "Оптимального метода нет";
        }
        if(vegStatus>3){//эутопия
            if(toFloat(refractionWithoutC)<=-4.125) return "Оптимального метода нет";
            if(toInt(time)<=9) return "Оптимален метод A";
            return "Оптимального метода нет";
        }
        if(!heredity) return "Оптимален метод A";
        if(toFloat(IN)<=28.07) return "Оптимального метода нет";
        if(toFloat(OOA)<=4.125) return "Оптимален метод А";
        if(toFloat(IN)<=35.917) {
            if(anxiety<3) return "Оптимален метод A";
            return "Оптимального метода нет";
        }
        if(toInt(time)<10){
            if(toFloat(OOA)<=7.625) return "Оптимального метода нет";
            return "Оптимален метод A";
        }
        if(toFloat(IN)<=69.265) return "Оптимального метода нет";
        return "Оптимален метод A";
    }

    public String count2(){
        if(toInt(age)<4){
            if(toFloat(IN)<=199.95)return "Оптимального метода нет";
            if(toFloat(OOAminus)<-3.375)  return "Оптимального метода нет";
        }
        if(method){
            if(myopia<3) return "Оптимален метод B";
            return "Оптимального метода нет";
        }
        if(vegStatus>3){//эутопия
            if(toFloat(refractionWithoutC)<=-4.125){
                if(toFloat(OOAminus)<=0.5)return "Оптимален метод A";
                return "Оптимального метода нет";
            }
            if(toFloat(OOAminus)<=0.125) return "Оптимального метода нет";
            return "Оптимален метод A";
        }
        if(toInt(time)<3){
            if(heredity) {
                if(toFloat(correction)<=0.375){
                    if(toInt(time)<2) return "Оптимален метод A";
                    return "Оптимального метода нет";
                }
                return "Оптимального метода нет";
            }
            if(toFloat(OOA)>7.625) return "Оптимален метод A";
            if(toFloat(OOAplus)>1.125) return "Оптимального метода нет";
            if(toFloat(IN)>34.793) return "Оптимален метод A";
            return "Оптимального метода нет";
        }
        if(toFloat(vision)>0.225){
            if(toInt(time)<=11)return "Оптимального метода нет";
            return "Оптимален метод A";
        }
        if(toFloat(vision)<=0.125) return "Оптимального метода нет";
        if(toFloat(refractionWithC)>-2.25) return "Оптимального метода нет";
        return "Оптимален метод A";
    }

    public String count3(){
        if(toInt(age)<4) return "Оптимального метода нет";
        if(method)return "Оптимален метод B";
        if(vegStatus>3){//эутопия
            if(toFloat(refractionWithoutC)<=-4.125) return "Оптимального метода нет";
            return "Оптимален метод A";
        }
        if(toInt(time)>2.5) return "Оптимального метода нет";
        if(heredity) return "Оптимален метод A";
        return "Оптимального метода нет";
    }

    public void setMyopia(int myopia) {
        this.myopia = myopia;
    }

    public int getMyopia() {
        return myopia;
    }

    public void setAnxiety(int anxiety) {
        this.anxiety = anxiety;
    }

    public int getAnxiety() {
        return anxiety;
    }

    public void setVegStatus(int vegStatus) {
        this.vegStatus = vegStatus;
    }

    public int getVegStatus() {
        return vegStatus;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getAge() {
        return age;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTime() {
        return time;
    }

    public void setIN(String IN) {
        this.IN = IN;
    }

    public String getIN() {
        return IN;
    }

    public void setVision(String vision) {
        this.vision = vision;
    }

    public String getVision() {
        return vision;
    }

    public void setCorrection(String correction) {
        this.correction = correction;
    }

    public String getCorrection() {
        return  correction;
    }

    public void setRefractionWithC(String refractionWithC) {
        this.refractionWithC = refractionWithC;
    }

    public String getRefractionWithC() {
        return  refractionWithC;
    }

    public void setRefractionWithoutC(String refractionWithoutC) {
        this.refractionWithoutC = refractionWithoutC;
    }

    public String getRefractionWithoutC() {
        return  refractionWithoutC;
    }

    public void setOOA(String OOA) {
        this.OOA = OOA;
    }


    public String getOOA() {
        return  OOA;
    }


    public void setOOAplus(String OOAplus) {
        this.OOAplus = OOAplus;
    }

    public String getOOAplus() {
        return  OOAplus;
    }

    public void setOOAminus(String OOAminus) {
        this.OOAminus = OOAminus;
    }

    public String getOOAminus() {
        return  OOAminus;
    }

    public void setMethod(boolean method) {
        this.method = method;
    }

    public boolean getMethod() {
        return method;
    }


    public void setHeredity(boolean heredity) {
        this.heredity = heredity;
    }

    public boolean getHeredity() {
        return heredity;
    }

    public int getModel() {
        return model;
    }

    public void setModel(int model) {
        this.model = model;
    }

    public static Integer toInt(String string){
        Integer result = Integer.parseInt(string);
        return result;
    }

    public static Float toFloat(String string){
        Float result = Float.parseFloat(string);
        return result;
    }
}
