package ai;

import java.util.Random;

public class Perceptron 
{
    private double[] weight;
    private double learningRange;
    private int epochs;

    public Perceptron(int inputSize, double learningRange, int epochs) 
    {
        this.learningRange = learningRange;
        this.epochs = epochs;
        this.weight = new double[inputSize + 1]; // +1 للانحياز (Bias)
        initializeWeight();
    }

    // تهيئة الأوزان بقيم عشوائية
    private void initializeWeight()
    {
        Random random = new Random();
        for (int i = 0; i < weight.length; i++) 
        {
            weight[i] = random.nextDouble() - 0.5;
        }
    }

    // دالة الخطوة لتحديد الإخراج
    private int activation(double sum)
    {
        return sum >= 0 ? 1 : 0;
    }

    // توقع إذا كانت البلاطة آمنة أو غير آمنة
    public int predict(double[] inputs) 
    {
        double sum = weight[0]; // الانحياز (Bias)
        for (int i = 0; i < inputs.length; i++) 
        {
            sum += inputs[i] * weight[i + 1];
        }
        return activation(sum);
    }

    // تدريب Perceptron
    public void train(double[][] data, int[] labels) 
    {
        for (int epoch = 0; epoch < epochs; epoch++)
        {
            int errors = 0;
            for (int i = 0; i < data.length; i++) 
            {
                int prediction = predict(data[i]);
                int error = labels[i] - prediction;

                // تحديث الأوزان بناءً على الخطأ
                weight[0] += learningRange * error; // تحديث الانحياز
                for (int j = 0; j < data[i].length; j++)
                {
                    weight[j + 1] += learningRange * error * data[i][j];
                }

                if (error != 0) 
                {
                    errors++;
                }
            }
            System.out.println("Epoch " + (epoch + 1) + " - Errors: " + errors);
            if (errors == 0) break; // التوقف المبكر إذا لم يكن هناك أخطاء
        }
        System.out.println("Training complete.");
    }

    // اختبار النموذج على بيانات جديدة
    public double test(double[][] testData, int[] testLabels)
    {
        int count = 0;
        for (int i = 0; i < testData.length; i++)
        {
            int prediction = predict(testData[i]);
            if (prediction == testLabels[i]) 
            {
                count++;
            }
        }
        return (double) count / testData.length * 100;
    }
}