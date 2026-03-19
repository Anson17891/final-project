// package com.bootcamp.project_stock_data.config;

// import java.io.BufferedReader;
// import java.io.IOException;
// import java.io.InputStreamReader;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.CommandLineRunner;
// import org.springframework.scheduling.annotation.Scheduled;
// import org.springframework.stereotype.Component;

// import com.bootcamp.project_stock_data.service.OhlcService;
// import com.bootcamp.project_stock_data.service.ProfileService;
// import com.bootcamp.project_stock_data.service.QuoteService;
// import com.bootcamp.project_stock_data.service.StockService;

// @Component
// public class AppStarter implements CommandLineRunner{
//   @Autowired
//   private StockService stockService;
//   @Autowired
//   private OhlcService ohlcService;
//   @Autowired
//   private ProfileService profileService;
//   @Autowired
//   private QuoteService quoteService;

//     @Override
//   public void run(String... args) throws Exception{
//     try{
//       initializeData();
//     }catch(Exception e){
//       System.err.println("Initialization failed: " + e.getMessage());
//         e.printStackTrace();

//     }
//   }

  // @Scheduled(cron = "0 0 0 30 * ?")   //!Only no-arg methods may be annotated with @Scheduled
  // public void dailyInitialization() throws Exception{
  //   initializeData();
  // }
  

//   private void initializeData() throws Exception{
// //do once the server start
// //1. delete old data (ohlc, profile)
// //2. load new data
// System.out.println("Start daily initialization...");

//   this.stockService.deleteAll();
// System.out.println("Stocks data deleted...");

// this.ohlcService.deleteAll();
// System.out.println("Ohlc data deleted...");

// this.profileService.deleteAll();
// System.out.println("Profiles data deleted...");

//   this.runPythonNotebook("python/_1_load_snp500_symbol.ipynb");
// System.out.println("Stocks data loaded...");

//   this.runPythonNotebook("python/_2_load_ohlcv_data.ipynb");
// System.out.println("Ohlc data loaded...");


//   this.profileService.saveAllProfiles();
// System.out.println("Profile data loaded...");

// System.out.println("Initialization completed...");
//   }

//   private void runPythonNotebook (String path) throws IOException, InterruptedException{
//     //!run python(ipynb) in spring boot, AI helped me again |||OTZ
//     ProcessBuilder pb = new ProcessBuilder("jupyter", "nbconvert", "--to", "notebook", "--execute", path);  //!not sure wether the address correct or not
//     pb.redirectErrorStream(true);
//     Process process = pb.start();

//     try (BufferedReader reader = new BufferedReader(
//         new InputStreamReader(process.getInputStream()))) {
//         String line;
//         while ((line = reader.readLine()) != null) {
//             System.out.println("Python output: " + line);
//         }
//     }

//     int exitCode = process.waitFor();
//     System.out.println("Python script finished with code: " + exitCode);
//   //!---------------------
//   }
// }



// //!ai suggest improvement
// // package com.bootcamp.project_stock_data.config;

// // import java.io.BufferedReader;
// // import java.io.IOException;
// // import java.io.InputStreamReader;

// // import org.slf4j.Logger;
// // import org.slf4j.LoggerFactory;
// // import org.springframework.beans.factory.annotation.Autowired;
// // import org.springframework.boot.CommandLineRunner;
// // import org.springframework.scheduling.annotation.Scheduled;
// // import org.springframework.stereotype.Component;

// // import com.bootcamp.project_stock_data.service.OhlcService;
// // import com.bootcamp.project_stock_data.service.ProfileService;
// // import com.bootcamp.project_stock_data.service.StockService;

// // @Component
// // public class AppStarter implements CommandLineRunner {

// //     private static final Logger log = LoggerFactory.getLogger(AppStarter.class);

// //     @Autowired
// //     private StockService stockService;
// //     @Autowired
// //     private OhlcService ohlcService;
// //     @Autowired
// //     private ProfileService profileService;

// //     @Override
// //     public void run(String... args) throws Exception {
// //         log.info("=== Application Startup Initialization ===");
// //         initializeData();
// //     }

// //     // 每天凌晨 2 點執行一次
// //     @Scheduled(cron = "0 0 2 * * ?")
// //     public void dailyInitTask() throws Exception {
// //         log.info("=== Daily Scheduled Initialization ===");
// //         initializeData();
// //     }

// //     private void initializeData() throws Exception {
// //         try {
// //             log.info("Deleting old data...");
// //             stockService.deleteAll();
// //             ohlcService.deleteAll();
// //             profileService.deleteAll();

// //             log.info("Loading new stock symbols...");
// //             runPythonNotebook("python/_1_load_snp500_symbol.ipynb");

// //             log.info("Loading OHLC data...");
// //             runPythonNotebook("python/_2_load_ohlcv_data.ipynb");

// //             log.info("Loading profile data...");
// //             profileService.saveAllProfiles();

// //             log.info("Initialization completed successfully.");
// //         } catch (Exception e) {
// //             log.error("Initialization failed: {}", e.getMessage(), e);
// //             throw e; // 可以選擇拋出或只記錄
// //         }
// //     }

// //     private void runPythonNotebook(String path) throws IOException, InterruptedException {
// //         ProcessBuilder pb = new ProcessBuilder("jupyter", "nbconvert", "--to", "notebook", "--execute", path);
// //         pb.redirectErrorStream(true);
// //         Process process = pb.start();

// //         try (BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()))) {
// //             String line;
// //             while ((line = reader.readLine()) != null) {
// //                 log.info("Python output: {}", line);
// //             }
// //         }

// //         int exitCode = process.waitFor();
// //         if (exitCode == 0) {
// //             log.info("Python notebook {} executed successfully.", path);
// //         } else {
// //             log.error("Python notebook {} failed with exit code {}", path, exitCode);
// //             throw new RuntimeException("Python execution failed for " + path);
// //         }
// //     }
// // }
