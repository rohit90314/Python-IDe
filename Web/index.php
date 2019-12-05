<?php
    //print_r($_POST);
    if(isset($_POST['ttt']))
    {
        $str = strval(get_client_ip());
        $myfile = fopen(strval($str).".py", "w") or die("Unable to open file!");
        $input = fopen(strval($str)."inp.txt", "w") or die("Unable to open file!");
        $txt = $_POST['ttt'];
        $inp_txt = $_POST['inp'];
        fwrite($myfile, $txt);
        fwrite($input, $inp_txt);
        
        /*$txt = "Jane Doe\n";
        fwrite($myfile, $txt);*/
        fclose($myfile);
        fclose($input);
        //echo $_POST['ttt'];
        $cmd = 'ping 192.168.0.1';
        $x='python '.$str.'.py<'.$str.'inp.txt';
    }
    function get_client_ip() {
        $ipaddress = '';
        if (isset($_SERVER['HTTP_CLIENT_IP']))
            $ipaddress = $_SERVER['HTTP_CLIENT_IP'];
        else if(isset($_SERVER['HTTP_X_FORWARDED_FOR']))
            $ipaddress = $_SERVER['HTTP_X_FORWARDED_FOR'];
        else if(isset($_SERVER['HTTP_X_FORWARDED']))
            $ipaddress = $_SERVER['HTTP_X_FORWARDED'];
        else if(isset($_SERVER['HTTP_FORWARDED_FOR']))
            $ipaddress = $_SERVER['HTTP_FORWARDED_FOR'];
        else if(isset($_SERVER['HTTP_FORWARDED']))
            $ipaddress = $_SERVER['HTTP_FORWARDED'];
        else if(isset($_SERVER['REMOTE_ADDR']))
            $ipaddress = $_SERVER['REMOTE_ADDR'];
        else
            $ipaddress = 'UNKNOWN';
        return $ipaddress;
    }

    
?>

<html>
    <head>
        <title>Fun</title>
    </head>
    <body>
        <div class='container'>
            Welcome to Python IDE : <div id='seconds'></div>
        </div>
        <form name="click" action="" method="post"> 
            <textarea rows="20" cols="100" class='re' id="ttt" name="ttt" onkeydown="if(event.keyCode===9){var v=this.value,s=this.selectionStart,e=this.selectionEnd;this.value=v.substring(0, s)+'\t'+v.substring(e);this.selectionStart=this.selectionEnd=s+1;return false;}"><?php if(isset($_POST['ttt'])){echo $_POST['ttt'];}?></textarea> <br><br>
            Input<br>
            <textarea rows="5" cols="100" class="re" id="inp" name="inp"><?php if(isset($_POST['inp'])){echo $_POST['inp'];}?></textarea> <br><br>
            <input type="submit" value="Submit">
    </form> 
        Result for <br>
        <?php
            if(isset($_POST['ttt']))
            {
                //echo ($x);
                echo "<BR>";
                //exec($x,$output); 
                //exec($x . PLUGIN_DIR . '/.htaccess ' . ABSPATH . '/.htaccess' . '2>&1',$output);
                ob_start();
                 exec($x . " 2>&1", $output);
                 $result = ob_get_contents();
                 ob_end_clean();
                 //var_dump($output);
                shell_exec("Hello my friend");
                foreach($output as $value){
                    echo "$value<br>";
                }
                //echo "<pre>".$output."</pre>";
            }
        ?>
        
        <script>
            
        </script>

        <!-- Script
        <script type='text/javascript'>

         var count = 0;
         var myInterval;
         // Active
         window.addEventListener('focus', startTimer);

         // Inactive
         window.addEventListener('blur', stopTimer);

         function timerHandler() {
          count++;
          document.getElementById("seconds").innerHTML = count;
         }

         // Start timer
         function startTimer() {
          console.log('focus');
          myInterval = window.setInterval(timerHandler, 1000);
         }

         // Stop timer
         function stopTimer() {
             console.log("Left");
             //window.alert("Hold on");
             

          window.clearInterval(myInterval);
         }
            
            window.addEventListener('beforeunload', function (e) { 
            e.preventDefault(); 
            e.returnValue = ''; 
        }); 
        </script>-->
    </body>
</html>