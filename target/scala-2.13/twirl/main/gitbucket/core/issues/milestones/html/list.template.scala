
package gitbucket.core.issues.milestones.html

import _root_.play.twirl.api.TwirlFeatureImports._
import _root_.play.twirl.api.TwirlHelperImports._
import _root_.play.twirl.api.Html
import _root_.play.twirl.api.JavaScript
import _root_.play.twirl.api.Txt
import _root_.play.twirl.api.Xml

object list extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template5[String,List[(gitbucket.core.model.Milestone, Int, Int)],gitbucket.core.service.RepositoryService.RepositoryInfo,Boolean,gitbucket.core.controller.Context,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(state: String,
  milestones: List[(gitbucket.core.model.Milestone, Int, Int)],
  repository: gitbucket.core.service.RepositoryService.RepositoryInfo,
  hasWritePermission: Boolean)(implicit context: gitbucket.core.controller.Context):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {
/*5.2*/import gitbucket.core.view.helpers


Seq[Any](_display_(/*6.2*/gitbucket/*6.11*/.core.html.main(s"Milestones - ${repository.owner}/${repository.name}")/*6.82*/{_display_(Seq[Any](format.raw/*6.83*/("""
  """),_display_(/*7.4*/gitbucket/*7.13*/.core.html.menu("milestones", repository)/*7.54*/{_display_(Seq[Any](format.raw/*7.55*/("""
    """),_display_(if(context.loginAccount.isDefined)/*8.40*/{_display_(Seq[Any](format.raw/*8.41*/("""
      """),format.raw/*9.7*/("""<div class="pull-right" style="margin-bottom: 10px;">
        <a class="btn btn-success" href=""""),_display_(/*10.43*/helpers/*10.50*/.url(repository)),format.raw/*10.66*/("""/issues/milestones/new">New milestone</a>
      </div>
    """)))} else {null} ),format.raw/*12.6*/("""
    """),format.raw/*13.5*/("""<table class="table table-bordered table-hover table-issues">
      <thead>
        <tr>
          <th>
            <a class="button-link"""),_display_(if(state == "open")/*17.54*/{_display_(Seq[Any](format.raw/*17.55*/(""" """),format.raw/*17.56*/("""selected""")))} else {null} ),format.raw/*17.65*/("""" href="?state=open">
              """),_display_(/*18.16*/milestones/*18.26*/.count(_._1.closedDate.isEmpty)),format.raw/*18.57*/(""" """),format.raw/*18.58*/("""Open
            </a>&nbsp;&nbsp;
            <a class="button-link"""),_display_(if(state == "closed")/*20.56*/{_display_(Seq[Any](format.raw/*20.57*/(""" """),format.raw/*20.58*/("""selected""")))} else {null} ),format.raw/*20.67*/("""" href="?state=closed">
              """),_display_(/*21.16*/milestones/*21.26*/.count(_._1.closedDate.isDefined)),format.raw/*21.59*/(""" """),format.raw/*21.60*/("""Closed
            </a>
          </th>
        </tr>
      </thead>
      <tbody>
        """),_display_(/*27.10*/defining(milestones.filter { case (milestone, _, _) =>
          milestone.closedDate.map(_ => state == "closed").getOrElse(state == "open")
        })/*29.11*/{ milestones =>_display_(Seq[Any](format.raw/*29.26*/("""
          """),_display_(/*30.12*/milestones/*30.22*/.map/*30.26*/ { case (milestone, openCount, closedCount) =>_display_(Seq[Any](format.raw/*30.72*/("""
          """),format.raw/*31.11*/("""<tr>
            <td style="padding-top: 15px; padding-bottom: 15px;">
              <div class="milestone row">
                <div class="col-md-4">
                  <a href=""""),_display_(/*35.29*/helpers/*35.36*/.url(repository)),format.raw/*35.52*/("""/milestone/"""),_display_(/*35.64*/milestone/*35.73*/.milestoneId),format.raw/*35.85*/("""" class="milestone-title">"""),_display_(/*35.112*/milestone/*35.121*/.title),format.raw/*35.127*/("""</a>
                  <div>
                    """),_display_(if(milestone.closedDate.isDefined)/*37.56*/{_display_(Seq[Any](format.raw/*37.57*/("""
                      """),format.raw/*38.23*/("""<span class="muted">Closed """),_display_(/*38.51*/gitbucket/*38.60*/.core.helper.html.datetimeago(milestone.closedDate.get)),format.raw/*38.115*/("""</span>
                    """)))}else/*39.28*/{_display_(Seq[Any](format.raw/*39.29*/("""
                      """),_display_(/*40.24*/milestone/*40.33*/.dueDate.map/*40.45*/ { dueDate =>_display_(Seq[Any](format.raw/*40.58*/("""
                        """),_display_(if(helpers.isPast(dueDate))/*41.53*/{_display_(Seq[Any](format.raw/*41.54*/("""
                          """),format.raw/*42.27*/("""<i class="octicon octicon-alert" style="color:#BD2C00;"></i>
                          <span class="muted milestone-alert">Due by """),_display_(/*43.71*/helpers/*43.78*/.date(dueDate)),format.raw/*43.92*/("""</span>
                        """)))}else/*44.32*/{_display_(Seq[Any](format.raw/*44.33*/("""
                          """),format.raw/*45.27*/("""<span class="muted">Due by """),_display_(/*45.55*/helpers/*45.62*/.date(dueDate)),format.raw/*45.76*/("""</span>
                        """)))}),format.raw/*46.26*/("""
                      """)))}/*47.24*/.getOrElse/*47.34*/ {_display_(Seq[Any](format.raw/*47.36*/("""
                        """),format.raw/*48.25*/("""<span class="muted">No due date</span>
                      """)))}),format.raw/*49.24*/("""
                    """)))}),format.raw/*50.22*/("""
                  """),format.raw/*51.19*/("""</div>
                </div>
                <div class="col-md-8">
                  """),_display_(/*54.20*/gitbucket/*54.29*/.core.issues.milestones.html.progress(openCount + closedCount, closedCount)),format.raw/*54.104*/("""
                  """),format.raw/*55.19*/("""<div>
                    <div>
                      """),_display_(if(closedCount == 0)/*57.44*/{_display_(Seq[Any](format.raw/*57.45*/("""
                        """),format.raw/*58.25*/("""0%
                      """)))}else/*59.30*/{_display_(Seq[Any](format.raw/*59.31*/("""
                        """),_display_(/*60.26*/((closedCount.toDouble / (openCount + closedCount).toDouble * 100).toInt)),format.raw/*60.99*/("""%
                      """)))}),format.raw/*61.24*/(""" """),format.raw/*61.25*/("""<span class="muted">complete</span> &nbsp;&nbsp;
                      """),_display_(/*62.24*/openCount),format.raw/*62.33*/(""" """),format.raw/*62.34*/("""<span class="muted">open</span> &nbsp;&nbsp;
                      """),_display_(/*63.24*/closedCount),format.raw/*63.35*/(""" """),format.raw/*63.36*/("""<span class="muted">closed</span>
                    </div>
                    <div class="milestone-menu">
                      """),_display_(if(hasWritePermission)/*66.46*/{_display_(Seq[Any](format.raw/*66.47*/("""
                        """),format.raw/*67.25*/("""<a href=""""),_display_(/*67.35*/helpers/*67.42*/.url(repository)),format.raw/*67.58*/("""/issues/milestones/"""),_display_(/*67.78*/milestone/*67.87*/.milestoneId),format.raw/*67.99*/("""/edit">Edit</a> &nbsp;&nbsp;
                        """),_display_(if(milestone.closedDate.isDefined)/*68.60*/{_display_(Seq[Any](format.raw/*68.61*/("""
                          """),format.raw/*69.27*/("""<a href=""""),_display_(/*69.37*/helpers/*69.44*/.url(repository)),format.raw/*69.60*/("""/issues/milestones/"""),_display_(/*69.80*/milestone/*69.89*/.milestoneId),format.raw/*69.101*/("""/open">Open</a> &nbsp;&nbsp;
                        """)))}else/*70.32*/{_display_(Seq[Any](format.raw/*70.33*/("""
                          """),format.raw/*71.27*/("""<a href=""""),_display_(/*71.37*/helpers/*71.44*/.url(repository)),format.raw/*71.60*/("""/issues/milestones/"""),_display_(/*71.80*/milestone/*71.89*/.milestoneId),format.raw/*71.101*/("""/close">Close</a> &nbsp;&nbsp;
                        """)))}),format.raw/*72.26*/("""
                        """),format.raw/*73.25*/("""<a href=""""),_display_(/*73.35*/helpers/*73.42*/.url(repository)),format.raw/*73.58*/("""/issues/milestones/"""),_display_(/*73.78*/milestone/*73.87*/.milestoneId),format.raw/*73.99*/("""/delete" class="delete">Delete</a>
                      """)))} else {null} ),format.raw/*74.24*/("""
                    """),format.raw/*75.21*/("""</div>
                  </div>
                </div>
              </div>
              """),_display_(/*79.16*/milestone/*79.25*/.description.map/*79.41*/ { description =>_display_(Seq[Any](format.raw/*79.58*/("""
                """),format.raw/*80.17*/("""<div class="milestone-description markdown-body">
                  """),_display_(/*81.20*/helpers/*81.27*/.markdown(
                    markdown         = description,
                    repository       = repository,
                    branch           = repository.repository.defaultBranch,
                    enableWikiLink   = false,
                    enableRefsLink   = false,
                    enableLineBreaks = true
                  )),format.raw/*88.20*/("""
                """),format.raw/*89.17*/("""</div>
              """)))}),format.raw/*90.16*/("""
            """),format.raw/*91.13*/("""</td>
          </tr>
          """)))}),format.raw/*93.12*/("""
          """),_display_(if(milestones.isEmpty)/*94.34*/{_display_(Seq[Any](format.raw/*94.35*/("""
          """),format.raw/*95.11*/("""<tr>
            <td style="padding: 20px; background-color: #eee; text-align: center;">
              No milestones to show.
              """),_display_(if(hasWritePermission)/*98.38*/{_display_(Seq[Any](format.raw/*98.39*/("""
                """),format.raw/*99.17*/("""<a href=""""),_display_(/*99.27*/helpers/*99.34*/.url(repository)),format.raw/*99.50*/("""/issues/milestones/new">Create a new milestone.</a>
              """)))} else {null} ),format.raw/*100.16*/("""
            """),format.raw/*101.13*/("""</td>
          </tr>
          """)))} else {null} ),format.raw/*103.12*/("""
        """),format.raw/*104.9*/("""</tbody>
      """)))}),format.raw/*105.8*/("""
    """),format.raw/*106.5*/("""</table>
  """)))}),format.raw/*107.4*/("""
""")))}),format.raw/*108.2*/("""
"""),format.raw/*109.1*/("""<script>
$(function()"""),format.raw/*110.13*/("""{"""),format.raw/*110.14*/("""
  """),format.raw/*111.3*/("""$('a.delete').click(function()"""),format.raw/*111.33*/("""{"""),format.raw/*111.34*/("""
    """),format.raw/*112.5*/("""return confirm('Once you delete this milestone, there is no going back.\nAre you sure?');
  """),format.raw/*113.3*/("""}"""),format.raw/*113.4*/(""");
"""),format.raw/*114.1*/("""}"""),format.raw/*114.2*/(""");
</script>
"""))
      }
    }
  }

  def render(state:String,milestones:List[(gitbucket.core.model.Milestone, Int, Int)],repository:gitbucket.core.service.RepositoryService.RepositoryInfo,hasWritePermission:Boolean,context:gitbucket.core.controller.Context): play.twirl.api.HtmlFormat.Appendable = apply(state,milestones,repository,hasWritePermission)(context)

  def f:((String,List[(gitbucket.core.model.Milestone, Int, Int)],gitbucket.core.service.RepositoryService.RepositoryInfo,Boolean) => (gitbucket.core.controller.Context) => play.twirl.api.HtmlFormat.Appendable) = (state,milestones,repository,hasWritePermission) => (context) => apply(state,milestones,repository,hasWritePermission)(context)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  SOURCE: src/main/twirl/gitbucket/core/issues/milestones/list.scala.html
                  HASH: ae69ea0164a2bce30396a0e3110d234e31a2a026
                  MATRIX: 739->1|1046->237|1109->273|1126->282|1205->353|1243->354|1272->358|1289->367|1338->408|1376->409|1442->449|1480->450|1513->457|1636->553|1652->560|1689->576|1792->636|1824->641|2008->798|2047->799|2076->800|2129->809|2193->846|2212->856|2264->887|2293->888|2409->977|2448->978|2477->979|2530->988|2596->1027|2615->1037|2669->1070|2698->1071|2817->1163|2977->1314|3030->1329|3069->1341|3088->1351|3101->1355|3185->1401|3224->1412|3431->1592|3447->1599|3484->1615|3523->1627|3541->1636|3574->1648|3629->1675|3648->1684|3676->1690|3787->1774|3826->1775|3877->1798|3932->1826|3950->1835|4027->1890|4079->1925|4118->1926|4169->1950|4187->1959|4208->1971|4259->1984|4339->2037|4378->2038|4433->2065|4591->2196|4607->2203|4642->2217|4698->2256|4737->2257|4792->2284|4847->2312|4863->2319|4898->2333|4962->2366|5005->2390|5024->2400|5064->2402|5117->2427|5210->2489|5263->2511|5310->2530|5425->2618|5443->2627|5540->2702|5587->2721|5689->2796|5728->2797|5781->2822|5830->2854|5869->2855|5922->2881|6016->2954|6072->2979|6101->2980|6200->3052|6230->3061|6259->3062|6354->3130|6386->3141|6415->3142|6597->3297|6636->3298|6689->3323|6726->3333|6742->3340|6779->3356|6826->3376|6844->3385|6877->3397|6992->3485|7031->3486|7086->3513|7123->3523|7139->3530|7176->3546|7223->3566|7241->3575|7275->3587|7352->3647|7391->3648|7446->3675|7483->3685|7499->3692|7536->3708|7583->3728|7601->3737|7635->3749|7722->3805|7775->3830|7812->3840|7828->3847|7865->3863|7912->3883|7930->3892|7963->3904|8065->3962|8114->3983|8232->4074|8250->4083|8275->4099|8330->4116|8375->4133|8471->4202|8487->4209|8853->4554|8898->4571|8951->4593|8992->4606|9056->4639|9117->4673|9156->4674|9195->4685|9385->4848|9424->4849|9469->4866|9506->4876|9522->4883|9559->4899|9671->4966|9713->4979|9791->5012|9828->5021|9875->5037|9908->5042|9951->5054|9984->5056|10013->5057|10063->5078|10093->5079|10124->5082|10183->5112|10213->5113|10246->5118|10366->5210|10395->5211|10426->5214|10455->5215
                  LINES: 14->1|20->5|23->6|23->6|23->6|23->6|24->7|24->7|24->7|24->7|25->8|25->8|26->9|27->10|27->10|27->10|29->12|30->13|34->17|34->17|34->17|34->17|35->18|35->18|35->18|35->18|37->20|37->20|37->20|37->20|38->21|38->21|38->21|38->21|44->27|46->29|46->29|47->30|47->30|47->30|47->30|48->31|52->35|52->35|52->35|52->35|52->35|52->35|52->35|52->35|52->35|54->37|54->37|55->38|55->38|55->38|55->38|56->39|56->39|57->40|57->40|57->40|57->40|58->41|58->41|59->42|60->43|60->43|60->43|61->44|61->44|62->45|62->45|62->45|62->45|63->46|64->47|64->47|64->47|65->48|66->49|67->50|68->51|71->54|71->54|71->54|72->55|74->57|74->57|75->58|76->59|76->59|77->60|77->60|78->61|78->61|79->62|79->62|79->62|80->63|80->63|80->63|83->66|83->66|84->67|84->67|84->67|84->67|84->67|84->67|84->67|85->68|85->68|86->69|86->69|86->69|86->69|86->69|86->69|86->69|87->70|87->70|88->71|88->71|88->71|88->71|88->71|88->71|88->71|89->72|90->73|90->73|90->73|90->73|90->73|90->73|90->73|91->74|92->75|96->79|96->79|96->79|96->79|97->80|98->81|98->81|105->88|106->89|107->90|108->91|110->93|111->94|111->94|112->95|115->98|115->98|116->99|116->99|116->99|116->99|117->100|118->101|120->103|121->104|122->105|123->106|124->107|125->108|126->109|127->110|127->110|128->111|128->111|128->111|129->112|130->113|130->113|131->114|131->114
                  -- GENERATED --
              */
          