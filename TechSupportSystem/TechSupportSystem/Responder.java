// Class Responder.java
import java.util.ArrayList;
import java.util.Random;

public class Responder {
    private Random randomGenerator;
    private ArrayList<String> responses;

    public Responder() {
        randomGenerator = new Random();
        responses = new ArrayList<>();
        fillResponses();
    }

    public String generateResponse() {
        int index = randomGenerator.nextInt(responses.size());
        return responses.get(index);
    }

    private void fillResponses() {
        responses.add("Apakah Anda sudah mencoba mematikan dan menyalakan ulang perangkat?");
        responses.add("Apakah semua kabel sudah terpasang dengan benar?");
        responses.add("Apakah Anda sudah mengupdate driver terbaru?");
        responses.add("Bisa dijelaskan lebih detail tentang masalahnya?");
        responses.add("Apakah ada pesan error yang muncul?");
        responses.add("Sejak kapan masalah ini terjadi?");
        responses.add("Apakah Anda sudah mencoba menghapus cache?");
        responses.add("Sudah mencoba menggunakan mode safe mode?");
        responses.add("Apakah masalah ini terjadi secara konsisten?");
        responses.add("Mari kita coba troubleshoot step by step.");
    }
}