# Progress Bar With Service
Class created for progress bar creation when using methods that may take time to load/terminate.

This code<br>
![PWBS-code](https://user-images.githubusercontent.com/6250218/54612602-00968800-4a38-11e9-9dcf-b5b456fc5b47.png)

Generate this result<br>
![result](https://user-images.githubusercontent.com/6250218/54612603-012f1e80-4a38-11e9-9672-5f295bdc241e.png)
![result2](https://user-images.githubusercontent.com/6250218/54612605-012f1e80-4a38-11e9-8c6d-51ee243ee682.png)

<b>When instantiating an object of this class, you must override two methods:</b>

- public R methodToBeLoad() throws Exception<br>
This method must contain the calls and executions that are responsible for the delay and the need to use this class.
<br><br>
- public void actionAfterSuccess(R result)<br>
This method must contain calls and executions that will process / use / execute the result of the methodToBeLoad () method. That is, the processes that must be executed after the expected completion of the task. 
