package procs;

/**
 * @author luojie
 * @Description
 * @date 2022/3/17 15/07
 */

import java.util.InputMismatchException;
import java.util.Scanner;

public class TriangleProc {

    public int sideA = 0;
    public int sideB = 0;
    public int sideC = 0;

    public TriangleProc() {

    }

    /**
     * 函数：验证三角形边的长度范围
     *
     * @param side
     * @return
     */
    public boolean verifyLengthRange(int side) {
        if ((side >= 1) && (side <= 100)) {
            return true;
        } else {
            System.out.println(String.format("边长 %1d 不满足大于等于1且小于等于 100", side));
            System.out.println("=========请重新输入=========");
            return false;
        }

    }

    /**
     * 函数：验证三角形两边之和大于第三边
     *
     * @param triangleProc
     * @return
     */
    public boolean verifyFormPrinciple(TriangleProc triangleProc) {

        if ((triangleProc.sideA + triangleProc.sideB <= triangleProc.sideC)
                || (triangleProc.sideA + triangleProc.sideC <= triangleProc.sideB)
                || (triangleProc.sideB + triangleProc.sideC <= triangleProc.sideA)) {
            System.out.println(String.format("边长组合为 %1d %2d %3d不满足两边之和大于第三边，是非三角形",
                    triangleProc.sideA, triangleProc.sideB, triangleProc.sideC));
            System.out.println("=========请重新输入=========");
            return false;
        } else {
            System.out.println("边长组合满足两边之和大于第三边");
            return true;
        }
    }


    public String judgeTriangleType(TriangleProc triangleProc) {
        if (triangleProc.sideA == triangleProc.sideB || triangleProc.sideA == triangleProc.sideC
                || triangleProc.sideB == triangleProc.sideC) {
            if (triangleProc.sideA == triangleProc.sideB && triangleProc.sideB == triangleProc.sideC) {
                String triangleType = "等边三角形";
                return triangleType;
            } else {
                String triangleType = "等腰三角形";
                return triangleType;
            }
        } else {
            String triangleType = "非等边三角形";
            return triangleType;
        }
    }

    public void inputEdge(Scanner scanner, TriangleProc triangleProc) {
        int tempSideA = 0;
        int tempSideB = 0;
        int tempSideC = 0;

//        System.out.println("Welcome to triangle judge program!!!d");
        System.out.println("Please input the side A");

        if (scanner.hasNext()) {
            tempSideA = scanner.nextInt();
            triangleProc.sideA = tempSideA;
            System.out.println(String.format("Edge A is %1d. Please input side B", tempSideA));
            tempSideB = scanner.nextInt();
            triangleProc.sideB = tempSideB;
            System.out.println(String.format("Edge B is %1d. Please input side C", tempSideB));
            tempSideC = scanner.nextInt();
            triangleProc.sideC = tempSideC;
            System.out.println(String.format("Edge C is %1d. The input is finished\n\n", tempSideC));

        }

        boolean stopFlag = false;

        while (!stopFlag) {
            if (verifyLengthRange(triangleProc.sideA) && verifyLengthRange(triangleProc.sideB)
                    && verifyLengthRange(triangleProc.sideC)) {
                if (verifyFormPrinciple(triangleProc)) {
                    stopFlag = true;
                    String triangleType = judgeTriangleType(triangleProc);
                    System.out.println(String.format("你输入的三角形类型为：%1s", triangleType));
                    System.out.println("========The End========");
                } else {
                    inputEdge(scanner, triangleProc);
                }

            } else {
                // 边长不满足两个条件，重新输入
                inputEdge(scanner, triangleProc);
            }
        }
    }


    /**
     * 主函数，同时也是测试函数
     *
     * @param args
     */
    public static void main(String[] args) {
        TriangleProc triangleProc = new TriangleProc();
        Scanner scanner = new Scanner(System.in);
        triangleProc.inputEdge(scanner, triangleProc);

    }

}