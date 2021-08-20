package OutOfMemoryTrouble;

import Core.MyHandler;
import com.sun.net.httpserver.HttpExchange;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.LinkedList;
import java.util.Scanner;

public class MainOutOfMemory extends MyHandler {
    LinkedList<MyObj> list;

    public MainOutOfMemory() {
        list = new LinkedList<>();
    }

    @Override
    public void handle(HttpExchange t) throws IOException {
        InputStreamReader isr =  new InputStreamReader(t.getRequestBody(),"utf-8");
        BufferedReader br = new BufferedReader(isr);
        final String value = br.readLine();
        System.out.println(value);


        String response = "This is the response";
        t.sendResponseHeaders(200, response.length());
        OutputStream os = t.getResponseBody();
        os.write(response.getBytes());
        os.close();

        Thread th = new Thread() {
            public void run() {
//                for (int j = 0; j < 1000; j++) {
                    MyObj obj = new MyObj();
//                    for (int k = 0; k < 1000; k++) {
                        obj.list.add(value);
//                    }
                    list.add(obj);
//                }
            }
        };

        th.start();
    }
}

