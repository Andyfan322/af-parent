package com.andyfan.oom;

/**
 * @author andyFan
 * @since 2019年05月18日
 */
public class HeapMemOmm {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        while (true) {
            sb.append(System.currentTimeMillis());
        }
    }
}
