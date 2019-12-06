-- example HTTP POST script which demonstrates the hitting of the initialization endpoint
-- HTTP method, body, and adding a header

wrk.method = "POST"
wrk.body   = '{"username": "loadTestName","deviceName": "loadTestDevice","deviceToken": "loadTestDeviceToken","platform": "loadTestPlatform","timezone": "loadTestTimeZone","device"

wrk.headers["Content-Type"] = "application/json"
wrk.headers["Authorization"] = "Basic YzgzNzI5NjMtNzUyZC00YWIzLWI4ODUtNThhNjcwODI4YmU3OjRmNWIxYjZmNTQ3MjRhMmJhZWQ0ZjM0NGFmODNjNzExM2IwZDcyZDcxZWZjNGI3MGJiYzFhNzdmMmIwZGM5MmY="

response = function(status, headers, body)
  if string.len(body) ~= 653 then
    io.write(string.len(body))
    io.write("\n")
  end
end
