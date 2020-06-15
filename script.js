
let csvToJson = require('convert-csv-to-json');
 
let fileInputName = 'student.csv'; 
let fileOutputName = 'output.json';
 
csvToJson.generateJsonFileFromCsv(fileInputName,fileOutputName);



