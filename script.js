var xlxs=require("xlsx");
var wb=xlxs.readFile("Dataset.xlsx");
var ws=wb.Sheets("school dataset");
console.log(ws);
