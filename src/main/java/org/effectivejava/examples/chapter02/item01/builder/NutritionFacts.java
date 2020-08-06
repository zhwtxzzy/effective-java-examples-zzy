package org.effectivejava.examples.chapter02.item01.builder;/**
 * @classname NutritionFacts
 * @description TODO
 * @author 张泽阳
 * @date 2020/8/6 15:28
 * @version 1.0
 */
public class NutritionFacts {
    private final int servingSize;
    private final int servings;
    private final int calories;
    private final int fat;
    private final int sodium;
    private final int carbohydrate;

    // ！！！静态内部类
    public static class Builder{
        // 和外部类一模一样的成员变量，只是区分了Required、Optional
        // Required parameters
        private final int servingSize;
        private final int servings;
        // Optional parameters - initialized to default values
        private int calories      = 0;
        private int fat           = 0;
        private int sodium        = 0;
        private int carbohydrate  = 0;
        // 必要参数 构造方法
        public Builder(int servingSize, int servings) {
            this.servingSize = servingSize;
            this.servings    = servings;
        }
        // ！！！返回Builder类型
        public Builder calories(int calories)
        { this.calories = calories;      return this; }
        public Builder fat(int fat)
        { this.fat = fat;           return this; }
        public Builder sodium(int sodium)
        { this.sodium = sodium;        return this; }
        public Builder carbohydrate(int carbohydrate)
        { this.carbohydrate = carbohydrate;  return this; }
        // ！！！返回NutritionFacts类型
        public NutritionFacts build(){return new NutritionFacts(this);}
    }

    private NutritionFacts(Builder builder){
        servingSize  = builder.servingSize;
        servings     = builder.servings;
        calories     = builder.calories;
        fat          = builder.fat;
        sodium       = builder.sodium;
        carbohydrate = builder.carbohydrate;
    }

    public static void main(String[] args) {
        NutritionFacts cola = new Builder(1, 2)
                .calories(100).sodium(35).carbohydrate(27).build();
    }
}
