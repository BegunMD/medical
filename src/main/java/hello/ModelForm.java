package hello;
import javax.validation.constraints.NotNull;

public class ModelForm {

    private int myopia;
    private int anxiety; //тревожность
    private int vegStatus;
    @NotNull
    private Integer age;
    @NotNull
    private Integer time;
    @NotNull
    private Float IN;
    @NotNull
    private Float vision;
    @NotNull
    private Float correction;
    @NotNull
    private Float refractionWithC;
    @NotNull
    private Float refractionWithoutC;
    @NotNull
    private Float OOA;
    @NotNull
    private Float OOAplus;
    @NotNull
    private Float OOAminus;
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
        if(age<4) return "Оптимального метода нет";
        if(method){
            if(myopia<3) return "Оптимален метод B";
            return "Оптимального метода нет";
        }
        if(vegStatus>3){//эутопия
            if(refractionWithoutC<=-4.125) return "Оптимального метода нет";
            if(time<=9) return "Оптимален метод A";
            return "Оптимального метода нет";
        }
        if(!heredity) return "Оптимален метод A";
        if(IN<=28.07) return "Оптимального метода нет";
        if(OOA<=4.125) return "Оптимален метод А";
        if(IN<=35.917) {
            if(anxiety<3) return "Оптимален метод A";
            return "Оптимального метода нет";
        }
        if(time<10){
            if(OOA<=7.625) return "Оптимального метода нет";
            return "Оптимален метод A";
        }
        if(IN<=69.265) return "Оптимального метода нет";
        return "Оптимален метод A";
    }

    public String count2(){
        if(age<4){
            if(IN<=199.95)return "Оптимального метода нет";
            if(OOAminus<-3.375)  return "Оптимального метода нет";
        }
        if(method){
            if(myopia<3) return "Оптимален метод B";
            return "Оптимального метода нет";
        }
        if(vegStatus>3){//эутопия
            if(refractionWithoutC<=-4.125){
                if(OOAminus<=0.5)return "Оптимален метод A";
                return "Оптимального метода нет";
            }
            if(OOAminus<=0.125) return "Оптимального метода нет";
            return "Оптимален метод A";
        }
        if(time<3){
            if(heredity) {
                if(correction<=0.375){
                    if(time<2) return "Оптимален метод A";
                    return "Оптимального метода нет";
                }
                return "Оптимального метода нет";
            }
            if(OOA>7.625) return "Оптимален метод A";
            if(OOAplus>1.125) return "Оптимального метода нет";
            if(IN>34.793) return "Оптимален метод A";
            return "Оптимального метода нет";
        }
        if(vision>0.225){
            if(time<=11)return "Оптимального метода нет";
            return "Оптимален метод A";
        }
        if(vision<=0.125) return "Оптимального метода нет";
        if(refractionWithC>-2.25) return "Оптимального метода нет";
        return "Оптимален метод A";
    }

    public String count3(){
        if(age<4) return "Оптимального метода нет";
        if(method)return "Оптимален метод B";
        if(vegStatus>3){//эутопия
            if(refractionWithoutC<=-4.125) return "Оптимального метода нет";
            return "Оптимален метод A";
        }
        if(time>2.5) return "Оптимального метода нет";
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

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getAge() {
        return age;
    }

    public void setTime(Integer time) {
        this.time = time;
    }

    public Integer getTime() {
        return time;
    }

    public void setIN(Float IN) {
        this.IN = IN;
    }

    public Float getIN() {
        return IN;
    }

    public void setVision(Float vision) {
        this.vision = vision;
    }

    public Float getVision() {
        return vision;
    }

    public void setCorrection(Float correction) {
        this.correction = correction;
    }

    public Float getCorrection() {
        return  correction;
    }

    public void setRefractionWithC(Float refractionWithC) {
        this.refractionWithC = refractionWithC;
    }

    public Float getRefractionWithC() {
        return  refractionWithC;
    }

    public void setRefractionWithoutC(Float refractionWithoutC) {
        this.refractionWithoutC = refractionWithoutC;
    }

    public Float getRefractionWithoutC() {
        return  refractionWithoutC;
    }

    public void setOOA(Float OOA) {
        this.OOA = OOA;
    }


    public Float getOOA() {
        return  OOA;
    }


    public void setOOAplus(Float OOAplus) {
        this.OOAplus = OOAplus;
    }

    public Float getOOAplus() {
        return  OOAplus;
    }

    public void setOOAminus(Float OOAminus) {
        this.OOAminus = OOAminus;
    }

    public Float getOOAminus() {
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
}
