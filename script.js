var xlxs=require("xlsx");
var wb=xlxs.readFile("Dataset.xlsx",{cellDates:true});
var ws=wb.Sheets["school dataset"];
var data=xlxs.utils.sheet_to_json(ws);
console.log(data);
