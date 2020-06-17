
let csvToJson = require('convert-csv-to-json');
 
let fileInputName = 'student_data2.csv'; 
let fileOutputName = 'output.json';
 
csvToJson.generateJsonFileFromCsv(fileInputName,fileOutputName);



