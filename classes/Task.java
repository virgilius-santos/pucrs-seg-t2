package classes;

import static classes.AES.Type.CBC;
import static classes.AES.Type.CTR;

public class Task {

        static Task task1 = new Task("Tarefa 1", "140b41b22a29beb4061bda66b6747e14",
                        "28a226d160dad07883d04e008a7897ee2e4b7465d5290d0c0e6c6822236e1daafb94ffe0c5da05d9476be028ad7c1d81",
                        "4ca00ff4c898d61e1edbf1800618fb28", CBC);
        static Task task2 = new Task("Tarefa 2", "140b41b22a29beb4061bda66b6747e14",
                        "b4832d0f26e1ab7da33249de7d4afc48e713ac646ace36e872ad5fb8a512428a6e21364b0c374df45503473c5242a253",
                        "5b68629feb8606f9a6667670b75b38a5", CBC);
        static Task task3 = new Task("Tarefa 3", "36f18357be4dbd77f050515c73fcf9f2",
                        "0ec7702330098ce7f7520d1cbbb20fc388d1b0adb5054dbd7370849dbf0b88d393f252e764f1f5f7ad97ef79d59ce29f5f51eeca32eabedd9afa9329",
                        "69dda8455c7dd4254bf353b773304eec", CTR);
        static Task task4 = new Task("Tarefa 4", "36f18357be4dbd77f050515c73fcf9f2",
                        "e46218c0a53cbeca695ae45faa8952aa0e311bde9d4e01726d3184c34451",
                        "770b80259ec33beb2561358a9f2dc617", CTR);
        static Task task5 = new Task("Tarefa 5", "36f18357be4dbd77f050515c73fcf9f2",
                        "5468697320697320612073656e74656e636520746f20626520656e63727970746564207573696e672041455320616e6420435452206d6f64652e",
                        "4ca00ff4c898d61e1edbf1800618fb28", CTR);
        static Task task6 = new Task("Tarefa 6", "140b41b22a29beb4061bda66b6747e14",
                        "4e657874205468757273646179206f6e65206f66207468652062657374207465616d7320696e2074686520776f726c642077696c6c2066616365206120626967206368616c6c656e676520696e20746865204c696265727461646f72657320646120416d6572696361204368616d70696f6e736869702e",
                        "4ca00ff4c898d61e1edbf1800618fb28", CBC);

        final String title;
        final String key;
        final String text;
        final String iv;
        final AES.Type type;

        Task(final String title, final String key, final String text, final String iv, final AES.Type type) {
                this.title = title;
                this.key = key;
                this.text = text;
                this.iv = iv;
                this.type = type;
        }
}