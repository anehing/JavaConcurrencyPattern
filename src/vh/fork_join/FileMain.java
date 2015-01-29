package vh.fork_join;

import java.util.concurrent.ForkJoinPool;

/**
 * Created by ane on 1/21/15.
 */
public class FileMain {

    public static void main(String args[]){
        ForkJoinPool pool = new ForkJoinPool();
        FolderProcessor system = new FolderProcessor("","");
        FolderProcessor app = new FolderProcessor("","");
        FolderProcessor documents = new FolderProcessor("","");

        pool.execute(system);
        pool.execute(app);
        pool.execute(documents);
    }
}
