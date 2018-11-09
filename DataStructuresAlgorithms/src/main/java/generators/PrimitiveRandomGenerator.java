package generators;

import java.util.Random;

/**
 * @Description : TODO
 * @Author : Ellie
 * @Date : 2018/11/8
 */
public class PrimitiveRandomGenerator {
    private static Random rand = new Random(47);
    public static class Boolean implements Generator<java.lang.Boolean> {
        @Override
        public java.lang.Boolean next() {
            return rand.nextBoolean();
        }
    }

    public static class Byte implements Generator<java.lang.Byte> {
        @Override
        public java.lang.Byte next() {
            return (byte)rand.nextInt();
        }
    }

    public static class Character implements Generator<java.lang.Character> {
        @Override
        public java.lang.Character next() {
            return PrimitiveGenerator.chars[rand.nextInt(PrimitiveGenerator.chars.length)];
        }
    }

    // Attention：Character已经是随机生成的了，不必重复实现
    public static class String extends PrimitiveGenerator.String {
        {
            cg = new Character();
        }
        public String() {}
        public String(int length) { super(length); }
    }

    public static class Short implements Generator<java.lang.Short> {
        @Override
        public java.lang.Short next() {
            return (short)rand.nextInt();
        }
    }

    public static class Integer implements Generator<java.lang.Integer> {
        private int mod = 10000;
        public Integer() {}
        public Integer(int mod) { this.mod = mod; }
        @Override
        public java.lang.Integer next() {
            return rand.nextInt(mod);
        }
    }

    public static class Long implements Generator<java.lang.Long> {
        private int mod = 10000;
        public Long() {}
        public Long(int mod) { this.mod = mod; }
        @Override
        public java.lang.Long next() {
            return new java.lang.Long(rand.nextInt(mod));
        }
    }

    public static class Float implements Generator<java.lang.Float> {
        @Override
        public java.lang.Float next() {
            int trimmed = Math.round(rand.nextFloat() * 100);
            return ((float)trimmed) / 100;
        }
    }

    public static class Double implements Generator<java.lang.Double> {
        @Override
        public java.lang.Double next() {
            long trimmed = Math.round(rand.nextDouble() * 100);
            return ((double)trimmed) / 100;
        }
    }
}
