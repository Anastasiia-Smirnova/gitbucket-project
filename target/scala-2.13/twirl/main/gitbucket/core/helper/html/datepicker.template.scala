
package gitbucket.core.helper.html

import _root_.play.twirl.api.TwirlFeatureImports._
import _root_.play.twirl.api.TwirlHelperImports._
import _root_.play.twirl.api.Html
import _root_.play.twirl.api.JavaScript
import _root_.play.twirl.api.Txt
import _root_.play.twirl.api.Xml

object datepicker extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template2[String,Option[java.util.Date],play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(name: String, value: Option[java.util.Date]):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {
/*2.2*/import gitbucket.core.view.helpers


Seq[Any](format.raw/*1.47*/("""
"""),format.raw/*3.1*/("""<div class="input-group date" data-date=""""),_display_(/*3.43*/value/*3.48*/.map(helpers.date)),format.raw/*3.66*/("""" style="width: 180px;">
  <input id=""""),_display_(/*4.15*/name),format.raw/*4.19*/("""" class="form-control" name=""""),_display_(/*4.49*/name),format.raw/*4.53*/("""" type="text" value=""""),_display_(/*4.75*/value/*4.80*/.map(helpers.date)),format.raw/*4.98*/(""""/>
  <span class="input-group-addon"><i class="octicon octicon-calendar"></i></span>
</div>
<script>
$(function()"""),format.raw/*8.13*/("""{"""),format.raw/*8.14*/("""
  """),format.raw/*9.3*/("""$('#"""),_display_(/*9.8*/name),format.raw/*9.12*/("""').datetimepicker("""),format.raw/*9.30*/("""{"""),format.raw/*9.31*/("""
    """),format.raw/*10.5*/("""format: 'YYYY-MM-DD'
  """),format.raw/*11.3*/("""}"""),format.raw/*11.4*/(""");
"""),format.raw/*12.1*/("""}"""),format.raw/*12.2*/(""");
</script>
"""))
      }
    }
  }

  def render(name:String,value:Option[java.util.Date]): play.twirl.api.HtmlFormat.Appendable = apply(name,value)

  def f:((String,Option[java.util.Date]) => play.twirl.api.HtmlFormat.Appendable) = (name,value) => apply(name,value)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  SOURCE: src/main/twirl/gitbucket/core/helper/datepicker.scala.html
                  HASH: 67a35cb6159f7e888b16d3de60e81b76e69a2a60
                  MATRIX: 610->1|728->49|792->46|820->85|888->127|901->132|939->150|1005->190|1029->194|1085->224|1109->228|1157->250|1170->255|1208->273|1353->391|1381->392|1411->396|1441->401|1465->405|1510->423|1538->424|1571->430|1622->454|1650->455|1681->459|1709->460
                  LINES: 14->1|17->2|20->1|21->3|21->3|21->3|21->3|22->4|22->4|22->4|22->4|22->4|22->4|22->4|26->8|26->8|27->9|27->9|27->9|27->9|27->9|28->10|29->11|29->11|30->12|30->12
                  -- GENERATED --
              */
          