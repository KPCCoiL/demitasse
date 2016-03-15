package kpccoil.demitasse

import org.apache.poi.ss.usermodel.Sheet
import org.apache.poi.ss.usermodel.Cell
import collection.JavaConversions._

case class Question(body: String, answer: String, genre: Option[String] = None)

object Question {
  def fromSheet(sheet: Sheet): Seq[Question] = sheet.map { row =>
    if (row.getLastCellNum < 3) None
    else row.take(3).map(cellStr) match {
      case Seq("", _, _) => None
      case Seq(_, "", _) => None
      case Seq(body, answer, "") => Some(Question(body, answer))
      case Seq(body, answer, genre) => Some(Question(body, answer, Some(genre)))
    }
  }.toSeq.flatten
  private def cellStr(cell: Cell) = cell.getCellType match {
    case Cell.CELL_TYPE_BOOLEAN => cell.getBooleanCellValue.toString
    case Cell.CELL_TYPE_FORMULA => cell.getCellFormula
    case Cell.CELL_TYPE_NUMERIC => cell.getNumericCellValue.toString
    case _ => cell.getStringCellValue
  }
}
